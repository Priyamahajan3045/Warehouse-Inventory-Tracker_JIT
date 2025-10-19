package com.warehouse;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        AlertService alertService = new AlertService();

        // Register observer
        warehouse.addObserver(alertService);

        // 1️⃣ Add new product
        warehouse.addProduct(1, "Laptop", 5);

        // 2️⃣ Receive shipment of 10 units
        warehouse.receiveShipment(1, 10);

        // 3️⃣ Fulfill 6 orders
        warehouse.fulfillOrder(1, 6);

        // 4️⃣ System should trigger automatic alert when low stock (4 left)
    }
}
