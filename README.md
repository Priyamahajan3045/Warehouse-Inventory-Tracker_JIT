# 🏭 Warehouse Inventory Tracker (JIT)

## 📘 Project Overview
The **Warehouse Inventory Tracker** is a simple Java-based console application that helps manage warehouse stock items efficiently.  
It allows users to:
- Add and manage product details.  
- Track stock levels dynamically.  
- Receive and fulfill orders.  
- Generate **low stock alerts** automatically.  
- Manage multiple warehouses and save data in a text file.

This project demonstrates concepts of **Object-Oriented Programming (OOP)**, **Observer Pattern**, **Collections**, **File Handling**, and **Multithreading** in Java.

---

## 🧩 Features Implemented (Day-wise)

### ✅ **Day 1 – Product Management**
- Created `Product` class with:
  - `id`, `name`, `quantity`, and `reorderThreshold`
- Methods:
  - `increaseStock()` → Adds incoming shipment.
  - `decreaseStock()` → Reduces stock on sale/order.
- Displayed **low stock alert** when quantity < threshold.

---

### ✅ **Day 2 – Warehouse Setup**
- Added `Warehouse` class for managing products.
- Features:
  - Add products to warehouse.
  - Receive shipments and fulfill orders.
  - Trigger alerts using `AlertService` when stock is low.
- Implemented **Observer pattern** for event-driven alerts.

---

### ✅ **Day 3 – Alert System**
- Created `StockObserver` (interface) and `AlertService` (implementation).
- `AlertService` listens to stock changes and displays alerts automatically.
- Improved warehouse interactions for better modularity.

---

### ✅ **Day 4 – Multi-Warehouse & Threads**
- Introduced `WarehouseManager` to handle **multiple warehouses**.
- Added **multithreading simulation** to represent simultaneous stock operations.
- Example:
  - Warehouse `Central` and `North` work in parallel using threads.

---

### ✅ **Day 5 – Data Persistence (Final Day)**
- Added file-based storage:
  - Automatically loads existing data from `inventory.txt` at startup.
  - Saves updated stock details after each operation.
- Displays confirmation message:


💾 Inventory saved to file successfully!


---

## 🧠 Concepts Used
- **Object-Oriented Programming (OOP)**
- **Collections Framework (HashMap, List)**
- **File Handling in Java**
- **Observer Design Pattern**
- **Multithreading**
- **Event-driven architecture**

---

## 🧰 Technologies Used
| Component | Technology |
|------------|-------------|
| Language | Java |
| IDE | Eclipse IDE |
| Collections | HashMap, List |
| Design Pattern | Observer |
| File Handling | Java I/O |
| Version Control | Git & GitHub |

---

## 🧪 How to Run the Project

1. **Clone the repository**
 ```bash
 git clone https://github.com/Priyamahajan3045/Warehouse-Inventory-Tracker_JIT.git



📂 Project Structure
WarehouseInventoryTracker/
│
├── src/com/warehouse/
│   ├── Main.java
│   ├── Product.java
│   ├── Warehouse.java
│   ├── WarehouseManager.java
│   ├── AlertService.java
│   └── StockObserver.java
│
├── inventory.txt
├── .project
├── .classpath
└── README.md
