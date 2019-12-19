package com.example.locdaika.adidi.model;

public class Acount_model {
    String FirtName, LastName, Number,Email,Pass,Code;

    public String getFirtName() {
        return FirtName;
    }

    public void setFirtName(String firtName) {
        FirtName = firtName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public Acount_model() {
    }

    public Acount_model(String firtName, String lastName, String number, String email, String pass, String code) {
        FirtName = firtName;
        LastName = lastName;
        Number = number;
        Email = email;
        Pass = pass;
        Code = code;
    }
}
