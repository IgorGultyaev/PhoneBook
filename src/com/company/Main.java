package com.company;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static PhoneBook phoneBook;

    public static PhoneBook addContact(PhoneBook phoneBook) {
        System.out.println("Фамилию");
        String surname = scanner.nextLine();
        String nameGroup;

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

        System.out.println("Введите имя группы");
        nameGroup = scanner.nextLine();
        phoneBook.addContactInGroup(nameGroup, contact);
        if (phoneBook.getPhoneBook().containsKey(null)) {
            phoneBook.getPhoneBook().remove(null);
        }
        return phoneBook;
    }


    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook(null, null);
        int choiceInt = -1;
        do {
            System.out.println("Выберите действие:");
            System.out.println("1. Создать список контактов автоматически");
            System.out.println("2. Создать контакт");
            System.out.println("3. Распечатать все контакты");
            System.out.println("4. Распечатать группу контактов");
            System.out.println("0. Выход");

            String choice = scanner.nextLine();
            choiceInt = Integer.parseInt(choice);


            switch (choiceInt) {
                case (1):
                    System.out.println("Введите количество контактов, которые необходимо создать");
                    String numberRecords = scanner.nextLine();
                    int intNumberRecords = Integer.parseInt(numberRecords);

                    phoneBook = DataGenerator.formationContacts(intNumberRecords, phoneBook);
                    break;
                case (2):
                    addContact(phoneBook);
                    break;

                case (3):
                    phoneBook.printContactsGroups();
                    break;
                case (4):
                    System.out.println("Введите имя группы: ");
                    String nameGroup = scanner.nextLine();
                    if (nameGroup == null) {
                        nameGroup = " ";
                    }
                    System.out.println();
                    if (phoneBook.getPhoneBook().containsKey(nameGroup)) {
                        phoneBook.printContactsInGroups(nameGroup);
                    } else {
                        System.out.println("Такого контакта не существует");
                    }
                    break;
            }
        } while (choiceInt != 0);
        scanner.close();
    }
}