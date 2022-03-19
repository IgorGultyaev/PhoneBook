package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class PhoneBook {
    private ArrayList<Contact> contacts;
    private String nameGroup;

    public PhoneBook(String nameGroup, ArrayList<Contact> contacts) {
        this.contacts = contacts;
        this.nameGroup = nameGroup;
    }

    public void addContactInGroup(Contact contact) {
        contacts.add(contact);
    }

    public String printContacts() {
        return contacts.toString();
    }

    @Override
    public String toString() {
        return nameGroup;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameGroup);
    }

    @Override
    public boolean equals(Object obj) {
        return obj.toString().equals(nameGroup);
    }

}
