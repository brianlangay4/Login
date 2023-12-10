package com.builtin.login.models;

public class User {
    private int id;
    private String number;
    private String name;
    private String password;
    private byte[] photo;
    private String gender;
    private String recoveryMessage;

    // Constructors

    public User() {
        // Default constructor
    }

    public User(int id, String number, String name, String password, byte[] photo, String gender, String recoveryMessage) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.password = password;
        this.photo = photo;
        this.gender = gender;
        this.recoveryMessage = recoveryMessage;
    }

    // Getters

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public String getGender() {
        return gender;
    }

    public String getRecoveryMessage() {
        return recoveryMessage;
    }

    // Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setRecoveryMessage(String recoveryMessage) {
        this.recoveryMessage = recoveryMessage;
    }
}
