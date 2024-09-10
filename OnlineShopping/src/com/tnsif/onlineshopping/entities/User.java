// Base class for Users
// Code by: Faza Ulfath
// Date: September 7, 2024
// Description: This abstract class represents a generic user in the online shopping system.
// It contains common attributes such as userId, username, and email, along with their getters
// and setters. It also provides a toString method for representing the user as a string.

package com.tnsif.onlineshopping.entities;

public abstract class User 
{
    private int userId;
    private String username;
    private String email;

    public User(int userId, String username, String email) 
    {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    // Getters and setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString () {
        return "User [userId=" + userId + ", username=" + username + ", email=" + email + "]";
    }
}
