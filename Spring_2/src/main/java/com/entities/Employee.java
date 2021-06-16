package com.entities;

public class Employee {
    private int id;
    private String name;
    private String address;
    private String email;
    private String gender;

    public Employee(int id, String name, String address, String email, String gender, String[] favorites, String position) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.favorites = favorites;
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getFavorites() {
        return favorites;
    }

    public void setFavorites(String[] favorites) {
        this.favorites = favorites;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String[] favorites;

    public Employee() {
    }

    private String position;

}
