package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private Map<String, ArrayList<Contact>> phoneBook;

    public PhoneBook(String nameGroup, ArrayList<Contact> contacts) {
        phoneBook = new HashMap<>();
        phoneBook.put(nameGroup, contacts);
    }

    public PhoneBook(Map<String, ArrayList<Contact>> phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void printContactsGroups() {
        this.phoneBook.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    public void printContactsInGroups(String nameGroups) {
        this.phoneBook.get(nameGroups).toString();

    }

    public Map<String, ArrayList<Contact>> getPhoneBook() {
        return phoneBook;
    }

    public void addContactInGroup(String nameGroup, Contact contact) {
        if (phoneBook.containsKey(nameGroup)) {
            phoneBook.get(nameGroup).add(contact);
        } else {
            ArrayList<Contact> contacts = new ArrayList<>();
            contacts.add(contact);
            phoneBook.put(nameGroup, contacts);
        }
    }

    @Override
    public String toString() {

        return phoneBook.toString();
    }

}
