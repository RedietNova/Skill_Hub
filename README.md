#  SkillHub – Skill Sharing & Learning Management System

##  Overview

SkillHub is a Java-based console application designed to connect Mentors and Learners through structured skill-sharing sessions. The platform allows users to register, log in, create learning sessions, manage skills, and provide feedback through reviews and ratings.

The system is built using Object-Oriented Programming (OOP) principles, JDBC database integration, file handling, and a layered architecture (Model–Service–DAO–Auth).

---

# ⚙️ 1. How to Set Up & Run the Project

##  Requirements
- Java JDK 8+
- VS Code / IntelliJ IDEA
- MySQL Server
- MySQL JDBC Connector (Driver)

---

##  Setup Steps

### 1. Clone or Download Project
SkillHubProject/
---

### 2. Create Database
CREATE DATABASE skillhub;
---

### 3. Configure Database Connection

Edit:
database/DBConnection.java
```java
String url = "jdbc:mysql://localhost:3306/skillhub";
String username = "root";
String password = "";

---

### 4. Add JDBC Driver
- Download MySQL Connector/J
- Add `.jar` file to project build path

---

### 5. Run Project

Run:
main/Main.java

---

# 2. Features

## 👤 User Features
- Mentor Registration
- Learner Registration
- Secure Login System
- Role-based Access Control

---

##  Skill Management
- Add Skills
- View Skills
- Manage Skill Data

---

##  Session Management
- Create Learning Sessions
- Mentor ↔ Learner connection
- Track learning progress

---

##  Review System
- Add Ratings (1–5)
- Submit Feedback
- View Reviews

---

##  System Features
- File handling (backup system)
- Exception handling
- JDBC database integration

---

#  3. Tech Stack

- Java (OOP)
- MySQL
- JDBC
- File I/O
- VS Code / IntelliJ
- GitHub

---

#  4. Group Members & Contribution

| Member | GitHub Username | Contribution |
|--------|----------------|--------------|
| 👤 Member 1 | Redu-Leul | Model Layer + Exception Handling |
| 👤 Member 2 | Obsinan| Service Layer (Business Logic) |
| 👤 Member 3 | RedietNova | Main Application + Database (JDBC + DAO) |
| 👤 Member 4 | Surafel Muluneh | Authentication System |
| 👤 Member 5 | Sibhaty18-boop | File Handling + Interfaces |

---

#  5. Project Architecture

Main (UI Layer)
   ↓
Service Layer (Business Logic)
   ↓
DAO Layer (Database Access)
   ↓
MySQL Database

---

#  6. Project Structure

SkillHubProject/
│
├── model/          → Entities (User, Mentor, Learner, Skill, Session, Review)
├── service/        → Business Logic Layer
├── database/       → JDBC + DAO Layer
├── auth/           → Authentication System
├── file/           → File Handling & Backup
├── exception/      → Custom Exceptions
├── interfaces/     → Polymorphism & Abstraction
└── main/           → Program Entry Point
`

---

#  7. OOP Concepts Used

- Encapsulation
- Inheritance
- Polymorphism
- Abstraction
- Interfaces
- Constructor Overloading
- Method Overriding
- Static & Instance Members
- this / super keyword
- Upcasting & Downcasting

---

#  8. Exception Handling

- try / catch / finally
- throw / throws
- Custom Exceptions:
  - InvalidLoginException
  - InvalidSkillException
  - InvalidRatingException

---

#  9. File Handling

- FileReader / FileWriter
- BufferedReader / BufferedWriter
- File operations:
  - createNewFile()
  - delete()
  - exists()
  - getName()
  - length()
  - mkdir()

---

#  10. Database Features

- JDBC Connection
- PreparedStatement
- ResultSet
- CRUD operations for:
  - Users
  - Skills
  - Sessions
  - Reviews

---

#  11. Edge Cases Handled

- Invalid login credentials
- Duplicate user registration
- Empty inputs
- Invalid rating (1–5 only)
- Database connection failure
- Null pointer handling
- File errors

---

#  12. Project Summary

SkillHub is a fully functional Java-based skill-sharing system that demonstrates real-world software engineering concepts including OOP design, layered architecture, database integration, file handling, and exception management.

---

# Author
 Developed as a group project for Object-Oriented Programming and Database Systems course.
