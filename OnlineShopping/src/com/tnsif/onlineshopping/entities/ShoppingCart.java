// Program to define ShoppingCart class
// Code by: Faza Ulfath
// Date: September 7, 2024
// Description: This class represents a shopping cart for storing items. It uses a HashMap 
// to keep track of products and their quantities. It includes methods to add and remove items 
// and to get the list of items in the cart.

package com.tnsif.onlineshopping.entities;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public void addItem(Product product, int quantity) {
        items.put(product, quantity);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    @Override
    public String toString() {
        return "ShoppingCart [toString()=" + super.toString() + "]";
    }
}
