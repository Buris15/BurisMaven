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

    public Contact searchContact(String name) {
        return contacts.get(name);
    }

    public boolean removeContact(String name) {
        if (contacts.remove(name) != null) {
            System.out.println("Contact removed.");
            return true;
        }
        return false;
    }

    public HashMap<String, Contact> getAllContacts() {
        return contacts;
    }

    public void saveToCSV(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Name,Phone,Email\n");
            for (Contact c : contacts.values()) {
                writer.write(c.toCsvString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
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
            System.out.println("Error loading file");
        }
    }
}