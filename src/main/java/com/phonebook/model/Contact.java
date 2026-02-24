package com.phonebook.model;

public class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    void setName(String name) {
        this.name = name;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    void setEmail(String email) {
        this.email = email;
    }

    public String toCsvString() {
        return name + "," + phoneNumber + "," + email;
    }
    
}
