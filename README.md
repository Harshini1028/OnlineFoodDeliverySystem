# 🍽 Online Food Delivery System

An end-to-end *Online Food Delivery System* built using *JSP, Servlets, JDBC, and **SQL database*. This web application allows customers to browse menu items, place or remove orders, while providing an admin interface for managing food items and user orders.

---

## 🔑 Core Functionalities

### 👤 Customer Login
- View all menu items
- Place food orders
- Remove placed orders

### 🛠 Admin Login
- View all registered customer details
- Add new menu items
- Edit existing menu items
- Delete menu items
- Monitor customer orders

---

## 💻 Tech Stack

- *Frontend:* JSP
- *Backend:* Java Servlets, JDBC
- *Database:* MySQL / SQL
- *Server:* Apache Tomcat

---

## 📂 Project Structure

- /login – Handles login for customer and admin
- /customer – Customer dashboard to view and order items
- /admin – Admin dashboard to manage menu and view customers
- /database – SQL schema and queries

---

## 🔐 Authentication

- Separate login mechanisms for:
  - *Admin*
  - *Customer*

Credentials are validated using JDBC against records stored in the SQL database.

---

## 🧾 How to Run

1. Clone the repository
2. Import the project in *Eclipse* or *IntelliJ*
3. Set up your MySQL database using provided SQL file
4. Update DB credentials in DBConnection.java
5. Deploy the project on *Apache Tomcat*
6. Access via browser:
   - Customer: /customerLogin.jsp
   - Admin: /adminLogin.jsp

---

## 📸 Screenshots

> Add your screenshots here (Customer Menu View, Order Page, Admin Dashboard, etc.)

---

## 🤝 Contributions

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---

## 📬 Contact

For queries, contact me at: [harshinimokkapati@gmail.com]
