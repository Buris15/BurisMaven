package com.phonebook.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import com.phonebook.model.Contact;

public class PhonebookService {

    private HashMap<String, Contact> contacts;

    public PhonebookService() {
        contacts = new HashMap<>();
    }

    public void addContact(Contact c) {
        contacts.put(c.getName(), c);
    }

    public void searchContact(String name) {
        if (contacts.containsKey(name)) {
            Contact c = contacts.get(name);
            System.out.println("Name: " + c.getName() + ", Phone: " + c.getPhoneNumber() + ", Email: " + c.getEmail());
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void removeContact(String name) {
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            System.out.println("Contact removed.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void saveToCSV(String filename) {
        StringBuilder sb = new StringBuilder("Name,Phone,Email\n");

        for (Contact c : contacts.values()) {
            sb.append(c.getName()).append(",")
                    .append(c.getPhoneNumber()).append(",")
                    .append(c.getEmail()).append("\n");
        }

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(sb.toString());
        } catch (IOException e) {
            System.out.println("Error saving to CSV: " + e.getMessage());
        }
    }

    public void loadFromCSV(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Contact c = new Contact(parts[0], parts[1], parts[2]);
                    addContact(c);
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading from CSV: " + e.getMessage());
        }
    }
}
