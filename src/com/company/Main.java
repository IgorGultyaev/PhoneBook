package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static int getRandom(int intRange){
        return  (int) (Math.random()*intRange);
    }

    public static void main(String[] args) {

        int reassigningNumber = 0;
        Map <String, Contact> contacts = new HashMap<>();
        String hashCode;
        for (int createMap = 0; createMap < 100; createMap++) {
            Contact contact = DataGenerator.generatingContactLimit();

            System.out.println(contact.getPhoneNumber().hashCode());
            contacts.put(contact.getPhoneNumber(), contact);
            System.out.println(contacts.containsKey(contact.getPhoneNumber()));

//            if (contacts.containsKey(contact.getPhoneNumber().hashCode())) {
//                reassigningNumber++;
//                System.out.println();
//
//           } else {
//                contacts.put(contact.getPhoneNumber(), contact);
//            }
            System.out.println(contact.toString());

//            contacts.put(contact.getPhoneNumber(), contact);
//            System.out.println(contact.toString());

        }
        System.out.println(reassigningNumber);
        System.out.println(contacts.toString());
        System.out.println(contacts.size());

        //TODO Сделал кривой код, в данном случаее имеется дублирование данный,
        // то есть под разными хэшами записаны одни и те же данные
        //TODO вот я борща сожрал, оказывается в мотод вызваемый от!!!
        // мапы указывать нужно не сам хеш код а ключевое слово!!!!!!! пора стать 
    }
}
