package com.example.myapplication;

public class User {
    private String email;
    private String password;
    private String userName;
    private String image;
    private String adress;
    private String key;

    public User(String userName, String email, String password, String image, String adress, String key) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.image = image;
        this.adress = adress;
        this.key = key;
    }

    public User() {
    }

    public User(String email, String password, String userName) {
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}