package com.phonebook;
import java.util.Scanner;

import com.phonebook.services.PhonebookService;

public class Main {
    public static void main(String[]args){
        PhonebookService service = new PhonebookService();
    
        Scanner scanner = new Scanner(System.in);
        System.out.println("MENU");
        System.out.println("1. Add");
        System.out.println("2. Search");
        System.out.println("3. Remove");
        System.out.println("4. Display All");
        System.out.println("5. Save to CSV");
        System.out.println("0. Exit");
        int choice = scanner.nextInt();
        scanner.nextLine();
        while (choice != 0) {
            switch (choice) {
                case 1:
                break;
                case 2:
                break;
                case 3:
                break;
                case 4:
                break;
                case 5:
                break;
                default:
                    System.out.println("Invalid choice try again.");
            }
            System.out.println("MENU");
            System.out.println("1. Add");
            System.out.println("2. Search");
            System.out.println("3. Remove");
            System.out.println("4. Display All");
            System.out.println("5. Save to CSV");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
        }

    }

    
    
}
