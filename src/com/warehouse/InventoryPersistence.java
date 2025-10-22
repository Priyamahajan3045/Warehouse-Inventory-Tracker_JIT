package com.warehouse;

import java.io.*;
import java.util.Map;

public class InventoryPersistence {

    private static final String FILE_PATH = "inventory_data.txt";

    public static void saveData(WarehouseManager manager) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Map.Entry<String, Warehouse> entry : manager.getWarehouses().entrySet()) {
                String warehouseName = entry.getKey();
                Warehouse wh = entry.getValue();
                for (Product product : wh.getInventory().values()) {
                    writer.write(warehouseName + "," +
                                 product.getId() + "," +
                                 product.getName() + "," +
                                 product.getQuantity() + "," +
                                 product.getReorderThreshold());
                    writer.newLine();
                }
            }
            System.out.println("💾 Inventory saved to file successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error saving data: " + e.getMessage());
        }
    }

    public static void loadData(WarehouseManager manager) {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("⚙️ No previous data found (first run).");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String warehouseName = parts[0];
                    int id = Integer.parseInt(parts[1]);
                    String name = parts[2];
                    int qty = Integer.parseInt(parts[3]);
                    int threshold = Integer.parseInt(parts[4]);

                    Warehouse wh = manager.getWarehouse(warehouseName);
                    if (wh == null) {
                        manager.addWarehouse(warehouseName);
                        wh = manager.getWarehouse(warehouseName);
                    }
                    Product product = new Product(id, name, threshold);
                    product.increaseStock(qty);
                    wh.addProduct(product);
                }
            }
            System.out.println("✅ Inventory data loaded from file!");
        } catch (IOException e) {
            System.out.println("❌ Error loading data: " + e.getMessage());
        }
    }
}
