# SkillHub – Skill Sharing & Learning Management System

## Overview

**SkillHub** is a Java-based console application designed to connect **Mentors** and **Learners** through structured skill-sharing sessions. The platform allows users to register, log in, create learning sessions, manage skills, and provide feedback through reviews and ratings.

The system is built using **Object-Oriented Programming (OOP)** principles, **JDBC database integration**, **file handling**, and a **layered architecture (Model → Service → DAO → Auth)**.

---

# ⚙️ 1. How to Set Up & Run the Project

## Requirements

* Java JDK 8+
* VS Code or IntelliJ IDEA
* MySQL Server
* MySQL JDBC Connector (Driver)

---

## Setup Steps

### 1. Clone or Download the Project

```text
SkillHubProject/
```

---

### 2. Create the Database

```sql
CREATE DATABASE skillhub;
```

---

### 3. Configure Database Connection

Edit the file:

```text
database/DBConnection.java
```

Update the database credentials:

```java
String url = "jdbc:mysql://localhost:3306/skillhub";
String username = "root";
String password = "";
```

---

### 4. Add JDBC Driver

* Download MySQL Connector/J
* Add the `.jar` file to your project's build path
* Ensure the driver is included in your IDE libraries

---

### 5. Run the Application

Execute:

```text
main/Main.java
```

---

# 🚀 2. Features

## 👤 User Features

* Mentor Registration
* Learner Registration
* Secure Login System
* Role-Based Access Control

---

## 🛠 Skill Management

* Add Skills
* View Skills
* Update Skill Information
* Manage Skill Data

---

## 📚 Session Management

* Create Learning Sessions
* Connect Mentors and Learners
* Track Learning Progress
* Manage Session Details

---

## ⭐ Review System

* Submit Ratings (1–5)
* Leave Feedback
* View Reviews and Ratings

---

## ⚡ System Features

* File Handling and Backup
* Exception Handling
* JDBC Database Integration
* Layered Application Architecture

---

# 💻 3. Tech Stack

| Technology              | Purpose                      |
| ----------------------- | ---------------------------- |
| Java                    | Core Application Development |
| OOP                     | Software Design Principles   |
| MySQL                   | Database Management          |
| JDBC                    | Database Connectivity        |
| File I/O                | Backup and Data Storage      |
| VS Code / IntelliJ IDEA | Development Environment      |
| Git & GitHub            | Version Control              |

---

# 👥 4. Group Members & Contributions

| Member   | GitHub Username | Contribution                             |
| -------- | --------------- | ---------------------------------------- |
| Member 1 | Redu-Leul       | Model Layer & Exception Handling         |
| Member 2 | Obsinan         | Service Layer (Business Logic)           |
| Member 3 | RedietNova      | Main Application & Database (JDBC + DAO) |
| Member 4 | Surafel Muluneh | Authentication System                    |
| Member 5 | Sibhaty18-boop  | File Handling & Interfaces               |

---

# 🏗️ 5. Project Architecture

```text
Main (UI Layer)
      ↓
Service Layer (Business Logic)
      ↓
DAO Layer (Database Access)
      ↓
MySQL Database
```

---

# 📂 6. Project Structure

```text
SkillHubProject/
│
├── model/         → Entities (User, Mentor, Learner, Skill, Session, Review)
├── service/       → Business Logic Layer
├── database/      → JDBC Connection & DAO Layer
├── auth/          → Authentication System
├── file/          → File Handling & Backup
├── exception/     → Custom Exceptions
├── interfaces/    → Abstraction & Polymorphism
└── main/          → Program Entry Point
```

---

# 🧩 7. OOP Concepts Used

The project demonstrates key Object-Oriented Programming concepts:

* Encapsulation
* Inheritance
* Polymorphism
* Abstraction
* Interfaces
* Constructor Overloading
* Method Overriding
* Static and Instance Members
* `this` and `super` Keywords
* Upcasting and Downcasting

---

# ⚠️ 8. Exception Handling

Implemented exception-handling mechanisms include:

* `try`
* `catch`
* `finally`
* `throw`
* `throws`

### Custom Exceptions

```java
InvalidLoginException
InvalidSkillException
InvalidRatingException
```

---

# 📁 9. File Handling

The system uses Java File I/O classes:

* FileReader
* FileWriter
* BufferedReader
* BufferedWriter

### Supported File Operations

```java
createNewFile()
delete()
exists()
getName()
length()
mkdir()
```

---

# 🗄️ 10. Database Features

The application integrates with MySQL using JDBC:

* JDBC Connection
* PreparedStatement
* ResultSet

### CRUD Operations

* Users
* Skills
* Sessions
* Reviews

---

# 🛡️ 11. Edge Cases Handled

The system validates and handles:

* Invalid Login Credentials
* Duplicate User Registration
* Empty User Inputs
* Invalid Ratings (Only 1–5 Allowed)
* Database Connection Failures
* Null Pointer Exceptions
* File Read/Write Errors

---

# 📋 12. Project Summary

**SkillHub** is a fully functional Java-based skill-sharing platform that demonstrates real-world software engineering practices through:

* Object-Oriented Programming
* Layered Architecture
* JDBC Database Integration
* File Handling
* Authentication & Authorization
* Exception Management

The project provides a practical implementation of concepts learned in **Object-Oriented Programming** and **Database Systems** courses while simulating a real-world learning and mentoring platform.

---

# 📜 License

This project was developed for educational purposes as part of an academic coursework project.

---

# ✍️ Author

Developed collaboratively as a group project for the **Object-Oriented Programming** and **Database Systems** course.
