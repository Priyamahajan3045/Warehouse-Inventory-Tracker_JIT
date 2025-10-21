package com.warehouse;
import com.warehouse.Warehouse;
import com.warehouse.WarehouseManager;


public class Main {
    public static void main(String[] args) {

        AlertService alertService = new AlertService();

        // Create warehouse manager
        WarehouseManager manager = new WarehouseManager();

        // Add multiple warehouses
        manager.addWarehouse("Central");
        manager.addWarehouse("North");

        manager.showWarehouses();

        // Add products to warehouses
        Warehouse central = manager.getWarehouse("Central");
        Warehouse north = manager.getWarehouse("North");

        central.addObserver(alertService);
        north.addObserver(alertService);

        Product laptop = new Product(1, "Laptop", 5);
        Product phone = new Product(2, "Smartphone", 3);

        central.addProduct(laptop);
        north.addProduct(phone);

        // Threads simulate simultaneous updates
        Thread t1 = new Thread(() -> {
            central.receiveShipment(1, 10);
            central.fulfillOrder(1, 6);
        });

        Thread t2 = new Thread(() -> {
            north.receiveShipment(2, 5);
            north.fulfillOrder(2, 4);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n✅ Simulation complete!");
    }
}
