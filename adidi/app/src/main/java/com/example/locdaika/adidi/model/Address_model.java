package com.example.locdaika.adidi.model;

public class Address_model {
    String address,
            city,
            state,
            country;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address_model() {

    }

    public Address_model(String address, String city, String state, String country) {

        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
    }
}
