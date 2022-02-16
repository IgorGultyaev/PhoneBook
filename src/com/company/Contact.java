package com.company;

import java.util.Objects;

public class Contact {
    private String names;
    private String surname;
    private String patronymic;
    private Gender gender;

    public Contact(String names, String surname, String patronymic, Gender gender) {
        this.names = names;
        this.surname = surname;
        this.patronymic = patronymic;
        this.gender = gender;
    }

    public String getFIO() {
        return names + " " + patronymic + " " + surname;
    }


    @Override
    public String toString() {
        return names + " "
                + patronymic + " "
                + surname + " "
                + "пол: " + gender;
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
        return Objects.hash(names,patronymic,surname,gender);
    }

}