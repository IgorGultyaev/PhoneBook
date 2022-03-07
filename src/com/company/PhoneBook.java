package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, Integer> contacts = new HashMap<>();
    private String groupName;

    public PhoneBook(String groupName, ArrayList<Contact> contacts) {
        for (Contact contactsToMap : contacts) {
            this.contacts.put(groupName, contacts.hashCode());
        }
    }

    public PhoneBook(String groupName) {
        this.contacts.put(groupName, null);
    }
}
