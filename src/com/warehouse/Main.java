package com.warehouse;

public class Main {
    public static void main(String[] args) {

        AlertService alertService = new AlertService();
        WarehouseManager manager = new WarehouseManager();

        // Load previous inventory data
        InventoryPersistence.loadData(manager);

        // Add warehouses if not already present
        if (manager.getWarehouse("Central") == null) manager.addWarehouse("Central");
        if (manager.getWarehouse("North") == null) manager.addWarehouse("North");

        Warehouse central = manager.getWarehouse("Central");
        Warehouse north = manager.getWarehouse("North");

        // Add observers
        central.addObserver(alertService);
        north.addObserver(alertService);

        // If no products, add default ones
        if (central.getInventory().isEmpty()) {
            central.addProduct(new Product(1, "Laptop", 5));
        }
        if (north.getInventory().isEmpty()) {
            north.addProduct(new Product(2, "Smartphone", 3));
        }

        // Simulate concurrent operations
        Thread t1 = new Thread(() -> {
            central.receiveShipment(1, 5);
            central.fulfillOrder(1, 4);
        });

        Thread t2 = new Thread(() -> {
            north.receiveShipment(2, 3);
            north.fulfillOrder(2, 2);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Save data after operations
        InventoryPersistence.saveData(manager);

        System.out.println("\n✅ Day 5 Simulation complete with file persistence!");
    }
}
