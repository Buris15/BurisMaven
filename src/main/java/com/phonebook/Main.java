package com.phonebook;

import java.util.Scanner;

import com.phonebook.model.Contact;
import com.phonebook.services.PhonebookService;

public class Main {

    public static void main(String[] args) {

        PhonebookService service = new PhonebookService();
        service.loadFromCSV("data/contacts.csv");

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMENU");
            System.out.println("1. Add");
            System.out.println("2. Search");
            System.out.println("3. Remove");
            System.out.println("4. Display All");
            System.out.println("5. Save to CSV");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    service.addContact(new Contact(name, phone, email));
                    System.out.println("Contact added.");
                    break;

                case 2:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();

                    Contact found = service.searchContact(searchName);

                    if (found != null) {
                        System.out.println("Name: " + found.getName());
                        System.out.println("Phone: " + found.getPhoneNumber());
                        System.out.println("Email: " + found.getEmail());
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter name to remove: ");
                    String removeName = scanner.nextLine();

                    if (!service.removeContact(removeName)) {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    if (service.getAllContacts().isEmpty()) {
                        System.out.println("No contacts available.");
                    } else {
                        for (Contact c : service.getAllContacts().values()) {
                            System.out.println(c.getName() + " | "
                                    + c.getPhoneNumber() + " | "
                                    + c.getEmail());
                        }
                    }
                    break;

                case 5:
                    service.saveToCSV("data/contacts.csv");
                    System.out.println("Contacts saved.");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        scanner.close();
    }
}