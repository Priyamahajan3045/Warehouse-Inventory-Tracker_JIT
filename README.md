# Warehouse Inventory Tracker

📌 **Overview**

The Warehouse Inventory Tracker is a **Java-based console application** designed to manage stock items across multiple warehouses. It allows adding products, updating stock levels, and generating **automatic low-stock alerts**. The project uses a modular structure for easy extension.

💡 **Features (Completed till Today)**

- Add and manage product details (ID, name, quantity, reorder level)  
- Manage multiple warehouses  
- Increase or decrease product stock  
- Automatic low-stock alerts when quantity goes below threshold  
- Observer pattern implementation for alerts (`AlertService`)  
- Thread-safe stock updates simulating concurrent warehouse operations  
- Modular structure using multiple Java classes:  
  - `Product.java` – Product details and stock management  
  - `Warehouse.java` – Individual warehouse operations  
  - `WarehouseManager.java` – Manage multiple warehouses  
  - `Main.java` – Simulation of warehouse operations with threads  

🧩 **Technologies Used**

- **Language:** Java (Core Java)  
- **IDE:** Eclipse  
- **Version Control:** Git & GitHub  

🚀 **How to Run**

1. Open the project in Eclipse IDE  
2. Navigate to `Main.java` inside `src/com/warehouse/`  
3. Run the program → It will display **warehouse operations and product stock updates** in the console  

🖥️ **Output Example**
🏭 Warehouse added: Central
🏭 Warehouse added: North

📦 Registered Warehouses:

Central

North

Product added: Laptop (ID: 1)
Product added: Smartphone (ID: 2)

📦 Received shipment of 10 for Laptop. Total: 10
📦 Received shipment of 5 for Smartphone. Total: 5

🛒 Fulfilled order of 6 for Laptop. Remaining: 4
🛒 Fulfilled order of 4 for Smartphone. Remaining: 1

⚠️ ALERT: Low stock for Laptop - only 4 left!
⚠️ ALERT: Low stock for Smartphone - only 1 left!

✅ Simulation complete!

