package com.company;

import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static Map<String, Contact> addContact(Map<String, Contact> contacts) {
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
            DataGenerator.formationGroupsByFirstSymbols(3, contact);
            System.out.println("Контакт добвлен в группу по первым символам фамилии");
        } else if (genderChoice.equals("нет")) {
            System.out.println("Контакт не добавлен не в одну группу");
        }
        contacts.put(phoneNumber, contact);
        return contacts;

    }

    public static void printContacts(Map<String, Contact> contacts) {
        System.out.println("Вывести на печать " + contacts.size() + " Записей? Введите да/нет");
        String choice = scanner.nextLine();
        if (choice.equals("да")) {
            contacts.forEach((key, value) -> System.out.println(key + " : " + value));
        }
    }

    public static void printContactsGroups(Map<String, ArrayList<Contact>> contacts) {
        System.out.println("Вывести на печать " + contacts.size() + " Записей? Введите да/нет");
        String choice = scanner.nextLine();
        if (choice.equals("да")) {
            contacts.forEach((key, value) -> System.out.println(key + " : " + value));
        }
    }

    public static void main(String[] args) {
        Map<String, Contact> contacts = new HashMap<>();
        int choiceInt = -1;
        do {
            System.out.println("Выберите действие:");
            System.out.println("1. Создать список контактов");
            System.out.println("2. Создать контакт");
            System.out.println("3. Распечатать все контакты");
            System.out.println("4. Распечатать все группы контактов");
            System.out.println("5. Найти контакт по номеру телефона");
            System.out.println("6. Распечатать группу контактов");

            System.out.println("0. Выход");

            String choice = scanner.nextLine();
            choiceInt = Integer.parseInt(choice);


            switch (choiceInt) {
                case (1):
                    System.out.println("Введите количество контактов, которые необходимо создать");
                    String numberRecords = scanner.nextLine();
                    int intNumberRecords = Integer.parseInt(numberRecords);
                    contacts = DataGenerator.formationContacts(intNumberRecords, contacts);
                    break;
                case (2):
                    addContact(contacts);
                    break;
                case (3):
                    printContacts(contacts);
                    break;
                case (4):
                    printContactsGroups(DataGenerator.contactGroup);
                    break;
                case (5):
                    System.out.println("Введите номер телефонав формате +7(921)-ХХХ-ХХ-ХХ");
                    System.out.print("+7(921)-");
                    String numberPhone = scanner.nextLine();
                    System.out.println();
                    numberPhone = "+7(921)-" + numberPhone;
                    if (contacts.containsKey(numberPhone)) {
                        long start = (new Date()).getTime();
                        System.out.println(contacts.get(numberPhone));
                        System.out.println("Найден за " + (((new Date()).getTime()) - start) + " миллисекунд");
                    } else {
                        System.out.println("Такого контакта не существует");
                    }
                    ;
                    break;
                case (6):
                    System.out.println("Введите имя группы контактов");
                    String nameGroup = scanner.nextLine();
                    if (DataGenerator.contactGroup.containsKey(nameGroup)) {
                        for (Contact contactInGroup : DataGenerator.contactGroup.get(nameGroup)) {
                            System.out.println(contactInGroup);
                        }
                    } else {
                        System.out.println("Такой группы не существует");
                    }

                    break;
            }
        } while (choiceInt != 0);
        scanner.close();
    }
}