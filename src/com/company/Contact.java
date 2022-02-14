package com.company;

public class Contact {
    private String names;
    private String surname;
    private String patronymic;
    private Gender gender;
    private String phoneNumber;

    public Contact(String names, String surname, String patronymic, Gender gender, String phoneNumber) {
        this.names = names;
        this.surname = surname;
        this.patronymic = patronymic;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public String getFIO() {
        return names + " " + patronymic + " " + surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return names + " "
                + patronymic + " "
                + surname + " "
                + "телефон: " + phoneNumber;
    }

    public boolean equals(Object obj){
        return this.toString().equals(obj.toString());
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}