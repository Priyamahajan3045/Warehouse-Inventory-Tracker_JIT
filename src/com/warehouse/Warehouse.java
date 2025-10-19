package com.warehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private Map<Integer, Product> products;         // productId → Product
    private List<StockObserver> observers;          // for alerts

    public Warehouse() {
        products = new HashMap<>();
        observers = new ArrayList<>();
    }

    // Register any observer (like AlertService)
    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    // Add a new product dynamically
    public void addProduct(int id, String name, int threshold) {
        if (products.containsKey(id)) {
            System.out.println("⚠️ Product with ID " + id + " already exists!");
            return;
        }
        Product product = new Product(id, name, threshold);
        products.put(id, product);
        System.out.println("✅ Product added: " + name + " (ID: " + id + ")");
    }

    // Increase stock (shipment)
    public void receiveShipment(int productId, int quantity) {
        Product product = products.get(productId);
        if (product == null) {
            System.out.println("❌ Invalid Product ID: " + productId);
            return;
        }
        product.increaseStock(quantity);
        System.out.println("📦 Received shipment of " + quantity + " for " + product.getName() +
                           ". Total: " + product.getQuantity());
    }

    // Fulfill order (decrease stock)
    public void fulfillOrder(int productId, int quantity) {
        Product product = products.get(productId);
        if (product == null) {
            System.out.println("❌ Invalid Product ID: " + productId);
            return;
        }
        if (product.getQuantity() < quantity) {
            System.out.println("⚠️ Not enough stock for " + product.getName());
            return;
        }

        product.decreaseStock(quantity);
        System.out.println("🛒 Fulfilled order of " + quantity + " for " + product.getName() +
                           ". Remaining: " + product.getQuantity());

        // Check for low stock automatically
        checkLowStock(product);
    }

    // Internal check
    private void checkLowStock(Product product) {
        if (product.getQuantity() <= product.getReorderThreshold()) {
            notifyObservers(product);
        }
    }

    // Notify all observers
    private void notifyObservers(Product product) {
        for (StockObserver observer : observers) {
            observer.onLowStock(product);
        }
    }
}
