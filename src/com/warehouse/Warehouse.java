package com.warehouse;

import java.util.*;

public class Warehouse {
    private String name;
    private Map<Integer, Product> inventory = new HashMap<>();
    private List<StockObserver> observers = new ArrayList<>();

    public Warehouse(String name) {
        this.name = name;
    }

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void addProduct(Product product) {
        inventory.put(product.getId(), product);
        System.out.println("Product added: " + product.getName() + " (ID: " + product.getId() + ")");
    }

    public void receiveShipment(int productId, int quantity) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.increaseStock(quantity);
            System.out.println("📦 Received shipment of " + quantity + " for " + product.getName() +
                               ". Total: " + product.getQuantity());
        } else {
            System.out.println("❌ Product ID " + productId + " not found in " + name + " warehouse.");
        }
    }

    public void fulfillOrder(int productId, int quantity) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.decreaseStock(quantity);
            System.out.println("🛒 Fulfilled order of " + quantity + " for " + product.getName() +
                               ". Remaining: " + product.getQuantity());

            if (product.getQuantity() < product.getReorderThreshold()) {
                for (StockObserver observer : observers) {
                    observer.onLowStock(product);
                }
            }
        } else {
            System.out.println("❌ Product ID " + productId + " not found in " + name + " warehouse.");
        }
    }

    public String getName() {
        return name;
    }
}
