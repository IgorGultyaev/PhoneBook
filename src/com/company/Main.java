package com.company;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static Map<String, PhoneBook> addContact(Map<String, PhoneBook> contactGroup) {
        System.out.println("Фамилию");
        String surname = scanner.nextLine();

        System.out.println("Имя");
        String name = scanner.nextLine();

        System.out.println("Отчество");
        String patronymic = scanner.nextLine();

        System.out.println("Пол: М/Ж");
        String genderChoice = scanner.nextLine();
        Gender gender;
        if (genderChoice.equals("М")) {
            gender = Gender.MAN;
        } else if (genderChoice.equals("Ж")) {
            gender = Gender.FEMALE;
        } else {
            System.out.println("Ок Пусть будет Ж");
            gender = Gender.FEMALE;
        }
        System.out.println("Телефон");
        String phoneNumber = scanner.nextLine();
        Contact contact = new Contact(name, surname, patronymic, gender, phoneNumber);
        System.out.println("Добавить новый контакт в группу по первым символам фамилии? введите да или нет");
        String сhoice = scanner.nextLine();
        if (сhoice.equals("да")) {
            DataGenerator.formationGroupsByFirstSymbols(3, contact, contactGroup);
            System.out.println("Контакт добвлен в группу по первым символам фамилии");
        } else if (genderChoice.equals("нет")) {
            System.out.println("Контакт не добавлен не в одну группу");
        }

        return DataGenerator.formationGroupsByFirstSymbols(1, contact, contactGroup);

    }
// TODO проравботать работу с generic или стрим и объеденить две процедуры в одну
//    public static void printContacts(Map<String, Contact> contact) {
//        System.out.println("Вывести на печать " + contact.size() + " Записей? Введите да/нет");
//        String choice = scanner.nextLine();
//        if (choice.equals("да")) {
//            contact.forEach((key, value) -> System.out.println(key + " : " + value));
//        }
//    }

    public static void printContactsGroups(Map<String, PhoneBook> contactGroup) {
        System.out.println("Вывести на печать " + contactGroup.size() + " Записей? Введите да/нет");
        String choice = scanner.nextLine();
        if (choice.equals("да")) {
            contactGroup.forEach((key, value) -> System.out.println(key + " : " + value.printContacts()));
        }
    }

    public static void main(String[] args) {

        Map<String, PhoneBook> contactGroup = new HashMap<>();
        int choiceInt = -1;
        do {
            System.out.println("Выберите действие:");
            System.out.println("1. Создать список контактов");
            System.out.println("2. Создать контакт");
            System.out.println("3. Распечатать все контакты");
            System.out.println("4. Распечатать группу контактов");
//            System.out.println("5. Распечатать группы");

            System.out.println("0. Выход");

            String choice = scanner.nextLine();
            choiceInt = Integer.parseInt(choice);


            switch (choiceInt) {
                case (1):
                    System.out.println("Введите количество контактов, которые необходимо создать");
                    String numberRecords = scanner.nextLine();
                    int intNumberRecords = Integer.parseInt(numberRecords);
                    contactGroup = DataGenerator.formationContacts(intNumberRecords, contactGroup);
                    break;
                case (2):
                    addContact(contactGroup);
                    break;

                case (3):
                    printContactsGroups(contactGroup);
                    break;
                case (4):
                    System.out.println("Введите имя группы: ");
                    String nameGroup = scanner.nextLine();
                    System.out.println();
                    if (contactGroup.containsKey(nameGroup)) {
                        long start = (new Date()).getTime();
                        contactGroup.get(nameGroup).printContacts();
                        System.out.println("Найден за " + (((new Date()).getTime()) - start) + " миллисекунд");
                    } else {
                        System.out.println("Такого контакта не существует");
                    }
                    break;
            }
        } while (choiceInt != 0);
        scanner.close();
    }
}