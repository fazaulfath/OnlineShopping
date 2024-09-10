// Program to test ProductService class
// Code by: Faza Ulfath
// Date: September 8, 2024
// Description: This class contains unit tests for the ProductService class,
// including methods to test adding, removing, retrieving products, and retrieving products by ID.

package com.tnsif.onlineshopping.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.tnsif.onlineshopping.entities.Product;
import com.tnsif.onlineshopping.services.ProductService;

public class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productService = new ProductService();
    }

    @Test
    public void testAddProduct() {
        Product product = new Product(1, "Laptop", 999.99, 10);
        productService.addProduct(product);
        assertNotNull(productService.getProductById(1));
    }

    @Test
    public void testRemoveProduct() {
        Product product = new Product(2, "Smartphone", 499.99, 20);
        productService.addProduct(product);
        productService.removeProduct(2);
        assertNull(productService.getProductById(2));
    }

    @Test
    public void testGetProductById() {
        Product product = new Product(3, "Tablet", 299.99, 15);
        productService.addProduct(product);
        Product retrievedProduct = productService.getProductById(3);
        assertEquals("Tablet", retrievedProduct.getName());
        assertEquals(299.99, retrievedProduct.getPrice());
    }

    @Test
    public void testGetProducts() {
        Product product1 = new Product(4, "Monitor", 199.99, 25);
        Product product2 = new Product(5, "Keyboard", 49.99, 30);
        productService.addProduct(product1);
        productService.addProduct(product2);
        assertEquals(2, productService.getProducts().size());
    }
}
