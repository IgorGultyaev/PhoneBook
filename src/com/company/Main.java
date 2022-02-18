package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
//    public static int getRandom(int intRange){
//        return  (int) (Math.random()*intRange);
//    }



    //TODO начал переделываеть в качестве хэк кода должен быть телефон, мы ищем контакт по номеру телефона
    // ТО DO так же необходимо группы в класс phone Book

    public static void main(String[] args) {

        int reassigningNumber = 0;
        Map <Contact, String> contacts = new HashMap<>();
        Map <String, ArrayList<Contact>> contactGroup = new HashMap<>();
        String hashCode;

        for (int createMap = 0; createMap < 10; createMap++) {
            Contact contact = DataGenerator.generatingContactLimit();
            String phone = DataGenerator.getRNDPhone(3);

            contacts.put(contact,phone);

            if (contactGroup.containsKey(contact.getSurname().substring(0,1))){
                contactGroup.get(contact.getSurname().substring(0,1)).add(contact);
            } else {
                contactGroup.put(contact.getSurname().substring(0, 1), new ArrayList<>());
                contactGroup.get(contact.getSurname().substring(0,1)).add(contact);
            }




//            contactGroup.put(contact.getSurname().substring(0),contact.hashCode());

            System.out.println(contacts.get(contact));
//            System.out.println(contact.getSurname().substring(0,1));



        }
//        System.out.println(reassigningNumber);
//        System.out.println(contacts.toString());
//        System.out.println(contacts.size());
//        System.out.println(contacts.keySet());
        System.out.println(contactGroup);

        //TODO дописать группы, объеденить все группы п пероай из фамилии, по 2 фимилии,
        // 3 буквам фамилии и ФИО инициалы попробовать одним классом


//для заметки в гит
        // Сделал кривой код, в данном случаее имеется дублирование данный,
        // то есть под разными хэшами записаны одни и те же данные
        // вот я борща сожрал, оказывается в мотод вызваемый от!!!
        // мапы указывать нужно не сам хеш код а ключевое слово!!!!!!! пора стать
    }
}
