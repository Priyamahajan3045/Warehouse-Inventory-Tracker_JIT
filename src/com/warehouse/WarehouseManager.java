package com.warehouse;

import java.util.*;

public class WarehouseManager {
    private Map<String, Warehouse> warehouses = new HashMap<>();

    public void addWarehouse(String name) {
        warehouses.put(name, new Warehouse(name));
        System.out.println("🏭 Warehouse added: " + name);
    }

    public Warehouse getWarehouse(String name) {
        Warehouse wh = warehouses.get(name);
        if (wh == null) {
            System.out.println("❌ Warehouse not found: " + name);
        }
        return wh;
    }

    public void showWarehouses() {
        System.out.println("\n📦 Registered Warehouses:");
        for (String name : warehouses.keySet()) {
            System.out.println("- " + name);
        }
    }

    public Map<String, Warehouse> getWarehouses() {
        return warehouses;
    }
}
