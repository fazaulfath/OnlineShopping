// Program to define CustomerService class
// Code by: Faza Ulfath
// Date: September 8, 2024
// Description: This class provides service-level operations for managing Customer entities in
// the online shopping system. It includes methods to add, retrieve, and list customers.

package com.tnsif.onlineshopping.services;

import java.util.ArrayList;
import java.util.List;

import com.tnsif.onlineshopping.entities.Customer;

public class CustomerService {
    private List<Customer> customerList = new ArrayList<>();

    // Method to add a customer
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    // Retrieve Customer by ID
    public Customer getCustomer(int userId) {
        return customerList.stream()
                .filter(customer -> customer.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

    // Get the list of all customers
    public List<Customer> getCustomers() {
        return customerList;
    }
}
