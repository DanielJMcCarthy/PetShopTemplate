package com.example.barkingmadpetstorev2;

public class UserModel {
    private String email;
    private String password;
    private String username;

    public UserModel(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public UserModel() {
    }

    public String toString() {
        return "UserModel{email='" + this.email + '\'' + ", password='" + this.password + '\'' + ", username='" + this.username + '\'' + '}';
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}