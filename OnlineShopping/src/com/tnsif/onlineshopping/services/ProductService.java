// Program to define Product Service - add, remove, retrieve products
// Code by: Faza Ulfath
// Date: September 8, 2024
// Description: This class provides service-level operations for managing Product entities in the
// online shopping system. It includes methods to add a product, remove a product by ID,
// retrieve a product by ID, and get the list of all products.

package com.tnsif.onlineshopping.services;

import java.util.ArrayList;
import java.util.List;

import com.tnsif.onlineshopping.entities.Product;

public class ProductService {
    private List<Product> productList = new ArrayList<>();

    // Method to add a product
    public void addProduct(Product product) {
        productList.add(product);
    }
    
    // Method to remove a product by ID
    public void removeProduct(int productId) {
        productList.removeIf(product -> product.getProductId() == productId);
    }
    
    // Method to retrieve the list of all products
    public List<Product> getProducts() {
        return productList;
    }
    
    // Method to retrieve a product by ID
    public Product getProductById(int productId) {
        return productList.stream()
                .filter(product -> product.getProductId() == productId)
                .findFirst()
                .orElse(null);
    }
}
