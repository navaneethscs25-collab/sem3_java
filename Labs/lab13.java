/*
Java 25/10/2026

Lab 13: Open-ended Exercise 2
Title: E-Commerce Inventory and Order Processing System

Problem Statement:
Design and implement an automated Inventory & Order Processing System using Java OOPs and Collections:
1. Create a custom exception InsufficientStockException.
2. Create a generic item representation Item<T> where T represents Item Code (alphanumeric or numeric).
   Include members name, price, and stockQuantity.
3. Create an InventoryManager to:
   - Add items to inventory using a HashMap<T, Item<T>>.
   - Process customer order requests. If the requested quantity exceeds stockQuantity,
     throw InsufficientStockException; otherwise deduct stock and compute total amount.
   - Display all items in inventory and low-stock alerts.
4. Demonstrate exception handling, generics, and collection frameworks.
*/

import java.util.HashMap;
import java.util.Map;

// Custom Exception for stock shortage
class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}

// Generic Class for Inventory Item
class Item<T> {
    private T itemCode;
    private String name;
    private double price;
    private int stockQuantity;

    Item(T itemCode, String name, double price, int stockQuantity) {
        this.itemCode = itemCode;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public T getItemCode() { return itemCode; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }

    public void reduceStock(int qty) {
        this.stockQuantity -= qty;
    }

    public void display() {
        System.out.printf("Code: %-10s | Item: %-18s | Price: Rs. %-8.2f | Stock: %-4d\n",
            itemCode, name, price, stockQuantity);
    }
}

// Inventory Manager using Generics and HashMap
class InventoryManager<T> {
    private Map<T, Item<T>> inventory = new HashMap<>();

    public void addItem(Item<T> item) {
        inventory.put(item.getItemCode(), item);
        System.out.println("Inventory Updated: Added \"" + item.getName() + "\" (" + item.getItemCode() + ")");
    }

    public void processOrder(T itemCode, int quantityRequested) throws InsufficientStockException {
        if (!inventory.containsKey(itemCode)) {
            System.out.println("Order Error: Item Code " + itemCode + " does not exist in inventory.");
            return;
        }

        Item<T> item = inventory.get(itemCode);
        if (quantityRequested > item.getStockQuantity()) {
            throw new InsufficientStockException("Insufficient Stock for " + item.getName() + 
                "! Requested: " + quantityRequested + ", Available: " + item.getStockQuantity());
        }

        item.reduceStock(quantityRequested);
        double totalCost = item.getPrice() * quantityRequested;
        System.out.printf("Order Placed: %d units of %s | Total: Rs. %.2f | Stock Left: %d\n",
            quantityRequested, item.getName(), totalCost, item.getStockQuantity());
    }

    public void displayInventory() {
        System.out.println("\n--- Current Inventory Status ---");
        for (Item<T> item : inventory.values()) {
            item.display();
        }
        System.out.println("---------------------------------");
    }
}

class lab13 {
    public static void main(String[] args) {
        System.out.println("=== E-Commerce Inventory & Order System (Open-Ended Exercise 2) ===");

        // Generic inventory with String item codes
        InventoryManager<String> store = new InventoryManager<>();

        store.addItem(new Item<>("LAP-001", "Gaming Laptop", 75000.0, 5));
        store.addItem(new Item<>("MOU-002", "Wireless Mouse", 850.0, 15));
        store.addItem(new Item<>("KEY-003", "Mechanical Keyboard", 3200.0, 8));

        store.displayInventory();

        // Successful order
        System.out.println("Processing valid order:");
        try {
            store.processOrder("MOU-002", 3);
            store.processOrder("LAP-001", 2);
        } catch (InsufficientStockException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Order exceeding stock (causes custom exception)
        System.out.println("\nProcessing order exceeding stock:");
        try {
            store.processOrder("LAP-001", 10);
        } catch (InsufficientStockException e) {
            System.out.println("Order Rejected -> Exception Caught: " + e.getMessage());
        }

        store.displayInventory();
    }
}

