# 🏫 SCHOOL MANAGEMENT SYSTEM (N-LAYERED ARCHITECTURE)

This project serves as a comprehensive management simulation developed in Java, focusing on applying object-oriented programming (OOP) and modern enterprise architecture principles.

---

## 🚀 1. KEY FEATURES
* **User Management:** Add, list, and find users (Students/Instructors).
* **Group Management:** Manual assignment and automated, fair group distribution.
* **Scheduler:** Random appointment assignment for presentations.
* **Academic:** Individual homework distribution and attendance tracking.

## ⚙️ 2. ARCHITECTURE & TECHNOLOGY

The most critical component is the layered architecture designed for maintainability and scalability.

* **Language:** Java SE (Core & OOP)
* **Architecture:** **N-Layered Architecture** (Entities, Business, DataAccess).
* **Coupling:** Interface-Driven design (`ProductDao` interface) ensuring **Loose Coupling** for easy future database transitions (JPA/Hibernate).
* **Persistence:** In-Memory List (for rapid prototyping).

## 🎲 3. ALGORITHM HIGHLIGHT (The Brain)
* **Core Logic:** The system uses the **Round-Robin** method for fair resource allocation.
* **Implementation:** Students are distributed to groups equally by leveraging **`Collections.shuffle`** and the **Modulo Operator (`%`)** logic.

---

## 💻 DEVELOPER
**Name:** Ahmet Yasin BasYigit
**Profile:** [linkedin.com/in/ahmetyasinbasyigit]
**Education:** Inönü University, Computer Programming
