// Program to test CustomerService class
// Code by: Faza Ulfath
// Date: September 8, 2024
// Description: This class contains unit tests for the CustomerService class,
// including methods to test adding and retrieving customers.

package com.tnsif.onlineshopping.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.tnsif.onlineshopping.entities.Customer;
import com.tnsif.onlineshopping.services.CustomerService;

public class CustomerServiceTest {

    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        customerService = new CustomerService();
    }

    @Test
    public void testAddCustomer() {
        Customer customer = new Customer(1, "JohnDoe", "john@example.com", "123 Elm Street");
        customerService.addCustomer(customer);
        assertNotNull(customerService.getCustomer(1));
    }

    @Test
    public void testGetCustomer() {
        Customer customer = new Customer(2, "JaneDoe", "jane@example.com", "456 Oak Avenue");
        customerService.addCustomer(customer);
        Customer retrievedCustomer = customerService.getCustomer(2);
        assertEquals("JaneDoe", retrievedCustomer.getUsername());
        assertEquals("456 Oak Avenue", retrievedCustomer.getAddress());
    }

    @Test
    public void testGetCustomers() {
        Customer customer1 = new Customer(3, "Alice", "alice@example.com", "789 Pine Road");
        Customer customer2 = new Customer(4, "Bob", "bob@example.com", "101 Maple Lane");
        customerService.addCustomer(customer1);
        customerService.addCustomer(customer2);
        assertEquals(2, customerService.getCustomers().size());
    }
}
