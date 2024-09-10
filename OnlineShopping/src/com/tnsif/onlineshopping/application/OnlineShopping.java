// Online Shopping Application
// Code by: Faza Ulfath
// Date: September 8, 2024
// Description: This Java program demonstrates an online shopping application with Admin and Customer modules. 
// The admin can manage products, view orders, and update order statuses
// Customers can create accounts, view products, and place orders

package com.tnsif.onlineshopping.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tnsif.onlineshopping.entities.Admin;
import com.tnsif.onlineshopping.entities.Customer;
import com.tnsif.onlineshopping.entities.Order;
import com.tnsif.onlineshopping.entities.Product;
import com.tnsif.onlineshopping.entities.ProductQuantityPair;
import com.tnsif.onlineshopping.services.AdminService;
import com.tnsif.onlineshopping.services.CustomerService;
import com.tnsif.onlineshopping.services.OrderService;
import com.tnsif.onlineshopping.services.ProductService;

public class OnlineShopping {
	// Here are the services that handle the core operations for products, customers, orders, and admins
	private static ProductService productService = new ProductService();
	private static CustomerService customerService = new CustomerService();
	private static OrderService orderService = new OrderService();
	private static AdminService adminService = new AdminService();

	public static void main (String[] args) {

		Scanner scanner = new Scanner (System. in);
		
		// Main loop for the whole application - keeps running until the user chooses to exit
		while (true) {
			System.out.println ("1. Admin Menu");
			System.out.println ("2. Customer Menu");
			System.out.println ("3. Exit");
			System.out. print ("Choose an option: ");
			int choice = scanner.nextInt();
			
			// Based on user choice, we either show the Admin menu, Customer menu, or exit
			switch (choice) {
			case 1: //Admin Module
				int adminChoice;
				do {
					System.out.println("\nAdmin Menu:");
					System.out.println ("1. Add Product");
					System.out.println("2. Remove Product");
					System.out.println ("3. View Products");
					System.out.println ("4. Create Admin");
					System.out.println("5. View Admins");
					System.out.println ("6. Update Order Status");
					System.out.println("7. View Orders");
					System.out.println("8. Return");
					System.out.print ("Choose an option: ");
					adminChoice = scanner.nextInt();
					
					// Admin Menu - this is where admins can manage products, view orders, etc.
					switch (adminChoice) {
					case 1:
						addProduct(scanner);
						break;
					case 2:
						removeProduct(scanner);
						break;
					case 3:
						viewProducts();
						break;
					case 4:
						createAdmin(scanner);
						break;
					case 5:
						viewAdmins() ;
						break;
					case 6:
						updateOrderStatus(scanner);
						break;
					case 7:
						viewOrders();
						break;
					case 8:
						System.out.println("Exiting Admin Menu...");
						break;
					default:
						System.out.println("Invalid choice! Please try again.");
					}
				} while (adminChoice != 8);
				
			case 2: //Customer Module
				int customerChoice;
				do {
					System.out.println("\nCustomer Menu:");
					System.out.println("1. Create Customer");
					System.out.println("2. View Customers");
					System.out.println("3. Place Order") ;
					System.out.println("4. View Orders") ;
					System.out.println("5. View Products");
					System.out.println("6. Return");
					System.out.print("Choose an option: ");
					customerChoice = scanner.nextInt();
					
					// Customer Menu - customers can browse products, create accounts, and place orders
					switch (customerChoice) {
					case 1:
						createCustomer(scanner);
						break;
					case 2:
						viewCustomers();
						break;
					case 3:
						placeOrder(scanner);
						break;
					case 4:
						viewOrdersForCustomer(scanner);
						break;
					case 5:
						viewProducts();
						break;
					case 6:
						System.out.println ("Exiting Customer Menu... ");
						break;
					default:
						System.out.println ("Invalid choice! Please try again.");
					}
				} while (customerChoice != 6);
				break;
				
				case 3:
					// If the user chooses to exit, we say goodbye and close the scanner
					System.out.println("Thanks for using the Online Shopping Application. Goodbye!");
					scanner.close ();
					return;
					
				default:
					// If the user enters anything unexpected, we guide them to try again
					System.out.println("Oops! That wasn't a valid choice. Please try again.");

				}

			}
			
		}
		
		// Adding a new product to the store
		private static void addProduct (Scanner scanner) {
			System.out.print("Enter Product ID: ");
			int productId = scanner.nextInt() ;
			System.out.print("Enter Product Name: ");
			String name = scanner.next();
			System.out.print("Enter Product Price: ");
			double price = scanner.nextDouble() ;
			System.out.print("Enter Stock Quantity: ");
			int stockQuantity = scanner.nextInt();

			Product product = new Product (productId, name, price, stockQuantity);
			productService.addProduct(product);
			System.out.println("Product added successfully!");
		}

		// Removing an existing product from the store
		private static void removeProduct (Scanner scanner) {
			System.out.print("Enter Product ID: ");
			int productId = scanner.nextInt();
			
			productService.removeProduct(productId);
			System.out.println("Product removed successfully!");
		}
		
		// Display all products that are available for purchase
		private static void viewProducts() {
	        List<Product> products = productService.getProducts();
	        if (products.isEmpty()) {
	            System.out.println("No products available.");
	        } else {
	            System.out.println("Product List:");
	            for (Product product : products) {
	                System.out.println("ID: " + product.getProductId() + ", Name: " + product.getName() +
	                                   ", Price: " + product.getPrice() + ", Stock: " + product.getStockQuantity());
	            }
	        }
	    }
		
		// Admins can create new admin accounts
		private static void createAdmin(Scanner scanner) {
	        System.out.print("Enter Admin ID: ");
	        int userId = scanner.nextInt();
	        System.out.print("Enter Admin Username: ");
	        String username = scanner.next();
	        System.out.print("Enter Admin Email: ");
	        String email = scanner.next();

	        Admin admin = new Admin(userId, username, email);
	        adminService.addAdmin(admin);
	        System.out.println("Admin created successfully!");
	    }

		// Display a list of all admins
	    private static void viewAdmins() {
	        System.out.println("List of Admins:");
	        for (Admin admin : adminService.getAdmins()) {
	            System.out.println(admin);
	        }
	    }
		
	    // Admins can update the status of a customer’s order
	    private static void updateOrderStatus(Scanner scanner) {
	        System.out.print("Enter Order ID: ");
	        int orderId = scanner.nextInt();
	        System.out.print("Enter New Status: ");
	        String status = scanner.next();

	        // Call the updateOrderStatus method and handle its boolean return type
	        boolean success = orderService.updateOrderStatus(orderId, status);
	        if (success) {
	            System.out.println("Order status updated successfully.");
	        } else {
	            System.out.println("Failed to update order status.");
	        }
	    }
		
	    // Display all orders placed by customers
		private static void viewOrders() {
	        List<Order> orders = orderService.getOrders();
	        if (orders.isEmpty()) {
	            System.out.println("No orders available.");
	        } else {
	            System.out.println("Order List:");
	            for (Order order : orders) {
	                System.out.println("Order ID: " + order.getOrderId() + ", Customer: " + order.getCustomer().getUsername() +
	                                   ", Status: " + order.getStatus());
	            }
	        }
	    }
		
		// Creating a new customer account
		private static void createCustomer(Scanner scanner) {
	        System.out.print("Enter User ID: ");
	        int userId = scanner.nextInt();
	        System.out.print("Enter Username: ");
	        String username = scanner.next();
	        System.out.print("Enter Email: ");
	        String email = scanner.next();
	        System.out.print("Enter Address: ");
	        String address = scanner.next();
	        
	        Customer customer = new Customer(userId, username, email, address);
	        customerService.addCustomer(customer);
	        System.out.println("Customer created successfully!");
	    }
		
		// Display all customers in the system
		private static void viewCustomers() {
	        List<Customer> customers = customerService.getCustomers();
	        if (customers.isEmpty()) {
	            System.out.println("No customers available.");
	        } else {
	            System.out.println("Customer List:");
	            for (Customer customer : customers) {
	                System.out.println("User ID: " + customer.getUserId() + ", Username: " + customer.getUsername() +
	                                   ", Email: " + customer.getEmail() + ", Address: " + customer.getAddress());
	            }
	        }
	    }
		
		// Customers can place an order for a product
		private static void placeOrder(Scanner scanner) {
		    System.out.print("Enter Customer ID: ");
		    int customerId = scanner.nextInt();
		    System.out.print("Enter Product ID: ");
		    int productId = scanner.nextInt();
		    System.out.print("Enter Quantity: ");
		    int quantity = scanner.nextInt();
		    
		    // Retrieve the product
		    Product product = productService.getProductById(productId);
		    if (product != null) {
		        // For the sake of simplicity, assume that the customer ID corresponds to a valid customer
		        Customer customer = customerService.getCustomer(customerId);
		        if (customer != null) {
		            // Create a ProductQuantityPair
		            ProductQuantityPair pair = new ProductQuantityPair(product, quantity);
		            List<ProductQuantityPair> products = new ArrayList<>();
		            products.add(pair);
		            
		            // Create a new Order (assume orderId is auto-generated or managed elsewhere)
		            int newOrderId = generateNewOrderId(); // Method to generate a new order ID
		            Order order = new Order(newOrderId, customer, "Pending", products);
		            
		            // Place the order
		            orderService.placeOrder(order);
		            System.out.println("Order placed successfully!");
		        } else {
		            System.out.println("Customer not found.");
		        }
		    } else {
		        System.out.println("Product not found.");
		    }
		}

		// Dummy method for generating a new order ID (replace with actual implementation)
		private static int generateNewOrderId() {
		    // This should be replaced with actual logic for generating a unique order ID
		    return (int) (Math.random() * 10000);
		}

		// Customers can view their own orders
		private static void viewOrdersForCustomer(Scanner scanner) {
		    System.out.print("Enter Customer ID: ");
		    int customerId = scanner.nextInt();
		    
		    List<Order> orders = orderService.getOrdersForCustomer(customerId);
		    if (orders.isEmpty()) {
		        System.out.println("No orders found for this customer.");
		    } else {
		        System.out.println("Order List for Customer ID " + customerId + ":");
		        for (Order order : orders) {
		            System.out.println("Order ID: " + order.getOrderId() + ", Status: " + order.getStatus());
		        }
		    }
		}
}
