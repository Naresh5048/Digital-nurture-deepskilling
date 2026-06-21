package com.cts.structures.exercise01;

import java.util.HashMap;
import java.util.Map;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Product [ID=" + productId + ", Name=" + productName + ", Qty=" + quantity + ", Price=" + price + "]";
    }
}

class Inventory {
    private Map<String, Product> productMap = new HashMap<>();

    public void addProduct(Product product) {
        productMap.put(product.getProductId(), product);
        System.out.println("Added: " + product.getProductName());
    }
    public void updateProduct(String productId, int newQuantity, double newPrice) {
        Product product = productMap.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
            System.out.println("Updated ID: " + productId);
        } else {
            System.out.println("Product not found for update.");
        }
    }
    public void deleteProduct(String productId) {
        Product removed = productMap.remove(productId);
        if (removed != null) {
            System.out.println("Deleted ID: " + productId);
        } else {
            System.out.println("Product not found for deletion.");
        }
    }
    public void displayInventory() {
        System.out.println("Current Inventory Stock Info:");
        for (Product p : productMap.values()) {
            System.out.println(p);
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== Warehouse Inventory Simulation ===\n");
        Inventory warehouse = new Inventory();

        warehouse.addProduct(new Product("P101", "Laptop", 15, 54000.00));
        warehouse.addProduct(new Product("P102", "Smartphone", 50, 22000.00));
        warehouse.displayInventory();

        System.out.println("\n--- Modifying Entries ---");
        warehouse.updateProduct("P101", 12, 53500.00);
        warehouse.deleteProduct("P102");
        warehouse.displayInventory();
    }
}