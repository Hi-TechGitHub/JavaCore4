package org.example.task2;

import java.util.ArrayList;
import java.util.List;
class Customer {
    private String name;
    private int age;
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}
class Product {
    private String name;
    private double price;
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}
class Order {
    private Customer customer;
    private Product product;
    private int quantity;
    public Order(Customer customer, Product product, int quantity) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
}
public class Main {
    private static List<Customer> customers = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();
    public static void main(String[] args) {
        customers.add(new Customer("John", 25));
        customers.add(new Customer("Alice", 30));
        products.add(new Product("Apple", 1.5));
        products.add(new Product("Banana", 2.0));
        try {
            Order order1 = makePurchase("John", "Apple", 2);
            orders.add(order1);
            System.out.println("Purchase successful: " + order1.getQuantity() + " " + order1.getProduct().getName());
            Order order2 = makePurchase("Alice", "Banana", -1);
            orders.add(order2);
            System.out.println("Purchase successful: " + order2.getQuantity() + " " + order2.getProduct().getName());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Total purchases: " + orders.size());
    }
    public static Order makePurchase(String customerName, String productName, int quantity) throws Exception {
        Customer customer = findCustomer(customerName);
        if (customer == null) {
            throw new Exception("Customer not found");
        }
        Product product = findProduct(productName);
        if (product == null) {
            throw new Exception("Product not found");
        }
        if (quantity < 0) {
            throw new Exception("Invalid quantity");
        }
        return new Order(customer, product, quantity);
    }
    private static Customer findCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }
    private static Product findProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
}