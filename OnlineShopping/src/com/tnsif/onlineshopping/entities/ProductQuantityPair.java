// Program to define ProductQuantityPair class
// Code by: Faza Ulfath
// Date: September 7, 2024
// Description: This class represents a pair consisting of a Product and its quantity. 
// It includes attributes for the product and quantity, along with their getters and setters.

package com.tnsif.onlineshopping.entities;

public class ProductQuantityPair {
    private Product product;
    private int quantity;

    public ProductQuantityPair(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters and setters
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
