package com.example.foodorderingapp;

public class User {
    public String username;
    public String email;
    public String password;

    //constructor
    public User(String username, String email, String password)
    {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    //setters and getters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
