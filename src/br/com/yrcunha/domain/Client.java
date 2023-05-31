package br.com.yrcunha.domain;

import java.util.Objects;

public class Client {
    private String name;
    private String document;
    private String phone;
    private String address;
    private String houseNumber;
    private String city;
    private String state;

    public Client(String name, String document, String phone, String address, String houseNumber, String city, String state) {
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        this.houseNumber = houseNumber;
        this.city = city;
        this.state = state;
    }

    public Client(String name, String document, String phone) {
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = null;
        this.houseNumber = null;
        this.city = null;
        this.state = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(document, client.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(document);
    }

    @Override
    public String toString() {
        return "Cliente :" + "nome='" + name + '\'' + ", CPF='" + document + '\'';
    }
}
