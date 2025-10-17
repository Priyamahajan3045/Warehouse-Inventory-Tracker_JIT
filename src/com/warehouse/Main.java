package com.warehouse;

public class Main {
    public static void main(String[] args) {
        Product laptop = new Product(1, "Laptop", 5);

        laptop.increaseStock(10);
        System.out.println("Current stock: " + laptop.getQuantity()); // 10

        laptop.decreaseStock(6);
        System.out.println("After selling 6: " + laptop.getQuantity()); // 4

        if (laptop.getQuantity() < laptop.getReorderThreshold()) {
            System.out.println("⚠️ Low stock for " + laptop.getName() +
                               " - only " + laptop.getQuantity() + " left!");
        }
    }
}
