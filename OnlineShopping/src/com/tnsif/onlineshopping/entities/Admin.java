// Program to define the Admin entity
// Code by: Faza Ulfath
// Date: September 7, 2024
// Description: This class defines the Admin entity in the online shopping application. 
// The Admin class extends the User class, inheriting user properties and methods.

package com.tnsif.onlineshopping.entities;

public class Admin extends User {
	// Constructor to initialize the Admin object with userId, username, and email
	public Admin (int userId, String username, String email) {
		super (userId, username, email) ;
	}
}