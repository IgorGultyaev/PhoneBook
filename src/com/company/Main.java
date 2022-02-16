package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int getRandom(int intRange){
        return  (int) (Math.random()*intRange);
    }

    public static void main(String[] args) {

        int reassigningNumber = 0;
        Map <Contact, String> contacts = new HashMap<>();
        String hashCode;
        for (int createMap = 0; createMap < 100; createMap++) {
            Contact contact = DataGenerator.generatingContactLimit();
            String phone = DataGenerator.getRNDPhone(3);

            contacts.put(contact,phone);

            System.out.println(contact.toString());

        }
        System.out.println(reassigningNumber);
        System.out.println(contacts.toString());
        System.out.println(contacts.size());
        System.out.println(contacts.keySet());


//для заметки в гит
        // Сделал кривой код, в данном случаее имеется дублирование данный,
        // то есть под разными хэшами записаны одни и те же данные
        // вот я борща сожрал, оказывается в мотод вызваемый от!!!
        // мапы указывать нужно не сам хеш код а ключевое слово!!!!!!! пора стать
    }
}
