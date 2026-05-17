
# 🏦 Bank Management System (JDBC Backend)

A Java JDBC-based backend application designed to manage core banking operations such as account creation, deposits, withdrawals, balance enquiry, and transaction management using MySQL database integration.

---

## 📌 Project Overview

The **Bank Management System** is a console-based backend application developed using **Java** and **JDBC**.  
It demonstrates database connectivity, CRUD operations, transaction handling, and modular backend architecture.

This project focuses purely on **backend development** and database interaction.

---

## 🚀 Features

✅ Create Bank Account  
✅ Deposit Money  
✅ Withdraw Money  
✅ Balance Enquiry  
✅ View Account Details  
✅ Transaction Handling  
✅ MySQL Database Integration  
✅ JDBC Connectivity  

---

## 🛠️ Technologies Used

- Java
- JDBC
- MySQL
- SQL
- Eclipse IDE
- Git & GitHub

---

## 📂 Project Structure

```

Bank-Management-System
│
├── src/
│ ├── dao/
│ ├── model/
│ ├── service/
│ ├── util/
│ └── Main.java
│
├── README.md

````

---

## ⚙️ Database Setup

1. Install MySQL
2. Create database:

```sql
CREATE DATABASE bank_db;
````

3. Create required tables:

```sql
CREATE TABLE accounts(
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    balance DOUBLE
);
```

4. Update database credentials in:

```
DBConnection.java
```

---

## ▶️ How to Run the Project

1. Clone repository

```bash
git clone https://github.com/HarshithaTD/bank-management-system-jdbc.git
```

2. Open project in Eclipse

3. Configure MySQL database

4. Run:

```
Main.java
```

---

## 💡 Learning Outcomes

* JDBC Database Connectivity
* CRUD Operations
* Backend Architecture Design
* SQL Query Execution
* Transaction Management
* Exception Handling

---

