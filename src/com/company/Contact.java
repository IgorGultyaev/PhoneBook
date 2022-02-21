package com.company;

import java.util.Objects;

public class Contact {
    private String names;
    private String surname;
    private String patronymic;
    private Gender gender;
    private final String phoneNumber;


    public Contact(String names, String surname, String patronymic, Gender gender, String phoneNumber) {
        this.names = names;
        this.surname = surname;
        this.patronymic = patronymic;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public String getFIO() {
        return surname + " " + names + " " + patronymic ;
    }


    @Override
    public String toString() {
        return surname + " "
                + names + " "
                + patronymic + " "
                + phoneNumber;

    }

    @Override //todo переписать метод так же как и в презентации у Юры, добавить допольнительные проверки
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass().equals(Contact.class)){
            return false;
        }
        Contact comparedContact = (Contact) obj;
        return toString().equals(comparedContact.toString());
    }

    @Override
    public int hashCode(){
        return Objects.hash(phoneNumber);
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}