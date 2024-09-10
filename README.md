# Online Shopping System
## Overview
This project is an Online Shopping System developed using Java. It includes features for managing users (Admins and Customers), handling products, placing and managing orders, and maintaining shopping carts. The system is designed with a focus on user management, product management, and order processing.

## Features
Admin Management: Admins can be added, retrieved, and removed.
Customer Management: Customers can be added, retrieved, and managed.
Product Management: Products can be added, removed, and retrieved.
Order Management: Orders can be placed, retrieved, and updated with various statuses (Pending, Completed, Cancelled, Delivered).
Shopping Cart: Customers can manage their shopping carts, adding and removing items.

## Classes and Functionality

### Entities:

User: Abstract base class for all user types.
Admin: Represents an admin user.
Customer: Represents a customer with additional fields for address, shopping cart, and orders.
Order: Represents an order with customer details, status, and a list of products.
Product: Represents a product with details like ID, name, price, and stock quantity.
ProductQuantityPair: Represents a pair of product and quantity.
ShoppingCart: Represents a shopping cart with products and quantities.

### Services:

AdminService: Provides methods to manage admins.
CustomerService: Provides methods to manage customers.
OrderService: Provides methods to place, update, retrieve, and list orders.
ProductService: Provides methods to add, remove, and retrieve products.
Getting Started

### Prerequisites

1. Java 8 or higher
2. An IDE like Eclipse or IntelliJ IDEA

### Installation

1. Clone the repository:
```bash
git clone https://github.com/fazaulfath/OnlineShopping.git
```

2. Open the project in your preferred IDE.

3. Build and run the project using your IDE's build and run options.

### Usage
Admin Management:
Use AdminService to add, remove, and retrieve admins.

Customer Management:
Use CustomerService to add, retrieve, and manage customers.

Product Management:
Use ProductService to add, remove, and retrieve products.

Order Management:
Use OrderService to place and update orders, and retrieve orders by ID.

Shopping Cart:
Customers can add and remove items from their shopping cart using ShoppingCart.

## Contributing
We welcome contributions to this project! If you would like to contribute, please follow these steps:

1. Fork the repository by clicking the "Fork" button in the upper right corner of the repository page.
2. Clone your forked repository to your local machine:
    ```bash
    git clone https://github.com/yourusername/your-forked-repo-name.git
    ```
3. Create a new branch for your changes:
    ```bash
    git checkout -b your-branch-name
    ```
4. Make your changes and commit them:
    ```bash
    git add .
    git commit -m "Description of your changes"
    ```
5. Push your changes to your forked repository:
    ```bash
    git push origin your-branch-name
    ```
6. Open a pull request from your forked repository to the original repository.

Please make sure to follow the project's coding standards and include tests for your changes.

### HAPPY CODING!
