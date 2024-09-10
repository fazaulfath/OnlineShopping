// Program to test OrderService class
// Code by: Faza Ulfath
// Date: September 8, 2024
// Description: This class contains unit tests for the OrderService class,
// including methods to test placing an order, updating the status, retrieving orders, and listing orders.

package com.tnsif.onlineshopping.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.tnsif.onlineshopping.entities.Customer;
import com.tnsif.onlineshopping.entities.Order;
import com.tnsif.onlineshopping.entities.Product;
import com.tnsif.onlineshopping.entities.ProductQuantityPair;
import com.tnsif.onlineshopping.services.CustomerService;
import com.tnsif.onlineshopping.services.OrderService;
import com.tnsif.onlineshopping.services.ProductService;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceTest {

    private OrderService orderService;
    private ProductService productService;
    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        orderService = new OrderService();
        productService = new ProductService();
        customerService = new CustomerService();

        // Create and add a product
        Product product = new Product(1, "Laptop", 999.99, 10);
        productService.addProduct(product);

        // Create and add a customer
        Customer customer = new Customer(1, "JohnDoe", "john@example.com", "123 Elm Street");
        customerService.addCustomer(customer);
    }

    @Test
    public void testPlaceOrder() {
        Product product = productService.getProductById(1);
        Customer customer = customerService.getCustomer(1);
        List<ProductQuantityPair> products = new ArrayList<>();
        products.add(new ProductQuantityPair(product, 2));
        Order order = new Order(1, customer, "Pending", products);
        orderService.placeOrder(order);
        assertNotNull(orderService.getOrder(1));
    }

    @Test
    public void testUpdateOrderStatusCompleted() {
        Product product = productService.getProductById(1);
        Customer customer = customerService.getCustomer(1);
        List<ProductQuantityPair> products = new ArrayList<>();
        products.add(new ProductQuantityPair(product, 2));
        Order order = new Order(1, customer, "Pending", products);
        orderService.placeOrder(order);
        boolean result = orderService.updateOrderStatus(1, "Completed");
        assertTrue(result);
        assertEquals("Completed", orderService.getOrder(1).getStatus());
    }

    @Test
    public void testUpdateOrderStatusCancelled() {
        Product product = productService.getProductById(1);
        Customer customer = customerService.getCustomer(1);
        List<ProductQuantityPair> products = new ArrayList<>();
        products.add(new ProductQuantityPair(product, 2));
        Order order = new Order(1, customer, "Pending", products);
        orderService.placeOrder(order);
        orderService.updateOrderStatus(1, "Completed");
        boolean result = orderService.updateOrderStatus(1, "Cancelled");
        assertTrue(result);
        assertEquals("Cancelled", orderService.getOrder(1).getStatus());
    }

    @Test
    public void testGetOrdersForCustomer() {
        Product product = productService.getProductById(1);
        Customer customer = customerService.getCustomer(1);
        List<ProductQuantityPair> products = new ArrayList<>();
        products.add(new ProductQuantityPair(product, 2));
        Order order = new Order(1, customer, "Pending", products);
        orderService.placeOrder(order);
        List<Order> orders = orderService.getOrdersForCustomer(1);
        assertEquals(1, orders.size());
    }
}
