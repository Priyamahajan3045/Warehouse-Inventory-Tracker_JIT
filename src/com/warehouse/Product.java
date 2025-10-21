package com.warehouse;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private int reorderThreshold;

    public Product(int id, String name, int reorderThreshold) {
        this.id = id;
        this.name = name;
        this.reorderThreshold = reorderThreshold;
        this.quantity = 0; // initially 0 stock
    }

    // Getters and Setters 
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getReorderThreshold() {
        return reorderThreshold;
    }

    public void increaseStock(int amount) {
        if (amount > 0) {
            quantity += amount;
        }
    }

    public boolean decreaseStock(int amount) {
        if (amount <= 0 || amount > quantity) {
            return false;
        }
        quantity -= amount;
        return true;
    }
}
