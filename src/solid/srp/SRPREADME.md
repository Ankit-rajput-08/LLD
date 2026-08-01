# Single Responsibility Principle (SRP)

## Definition

> **"A class should have only one reason to change."**

In simple words:

> **A class should have only one job or one responsibility.**

If a class is responsible for multiple things, then a change in any one of those responsibilities forces the class to change.

---

# The Real Meaning

SRP is about **keeping responsibilities separated**.

A class should represent **one concept**, not multiple unrelated concepts.

Think of every class as an employee in a company.

Every employee should have **one role**.

If one employee is handling sales, accounting, customer support, and marketing together, problems become inevitable.

Similarly, if one class performs many unrelated tasks, it becomes difficult to understand, test, maintain, and modify.

---

# What is a Responsibility?

A responsibility is **a reason for a class to change**.

Examples:

- Business rules change.
- Database technology changes.
- Email format changes.
- Logging strategy changes.
- PDF format changes.

If one class is affected by multiple kinds of changes, it has multiple responsibilities.

---

# Real-Life Analogy

Imagine a restaurant.

## ❌ Bad Design

One employee is responsible for:

- Taking customer orders
- Cooking food
- Preparing bills
- Cleaning tables
- Purchasing groceries

Whenever any one of these processes changes, that employee's work changes.

The employee becomes overloaded.

Mistakes become common.

---

## ✅ Good Design

Separate responsibilities.

```text
Restaurant

Chef
    → Cooks food

Waiter
    → Takes orders

Cashier
    → Handles billing

Cleaner
    → Cleans tables

Manager
    → Purchases groceries
```

Each employee has one clear responsibility.

If billing changes,

only the cashier's work changes.

Everyone else continues working without modification.

---

# Software Example

Suppose we have a `User` class.

## ❌ Bad Design

```java
class User {

    public void registerUser() {
        // Registration logic
    }

    public void saveToDatabase() {
        // Database logic
    }

    public void sendWelcomeEmail() {
        // Email logic
    }

    public void generateReport() {
        // PDF generation logic
    }
}
```

---

## Why is this bad?

This class has multiple responsibilities.

It is responsible for:

- User registration
- Database operations
- Email sending
- Report generation

Each responsibility can change independently.

Examples:

- Database changes from MySQL to MongoDB.
- Email provider changes.
- Report format changes.
- Registration validation changes.

Now this single class must change for four completely different reasons.

That violates SRP.

---

# ✅ Better Design

Separate responsibilities into dedicated classes.

```text
UserService
    → Registration logic

UserRepository
    → Database operations

EmailService
    → Sends emails

ReportService
    → Generates reports
```

Each class has one job.

Now changes remain isolated.

---

# Another Example — Student Management System

## ❌ Bad Design

```java
class Student {

    public void calculateGrade() {
    }

    public void saveStudent() {
    }

    public void sendEmail() {
    }

    public void printReportCard() {
    }
}
```

The `Student` class is trying to do everything.

It represents:

- Business logic
- Database logic
- Email service
- Printing

These responsibilities have nothing to do with one another.

---

## ✅ Good Design

```text
Student
    → Student information

GradeCalculator
    → Grade calculation

StudentRepository
    → Database operations

EmailService
    → Email notifications

ReportCardPrinter
    → Printing reports
```

Now every class has a single purpose.

---

# Benefits of SRP

## 1. Easier Maintenance

A change affects only one class.

No need to search through hundreds of lines of unrelated code.

---

## 2. Easier Testing

Small classes are easier to unit test.

Each class has fewer scenarios to verify.

---

## 3. Better Readability

Developers immediately understand the purpose of a class.

Large "God Classes" disappear.

---

## 4. Better Reusability

A focused class can be reused in multiple projects.

For example,

`EmailService`

can be reused anywhere email functionality is needed.

---

## 5. Fewer Merge Conflicts

When multiple developers work on different responsibilities,

they modify different classes.

This reduces Git merge conflicts.

---

# Warning Signs of an SRP Violation

| Warning Sign | What It Means |
|--------------|---------------|
| Class name contains words like **Manager**, **Utility**, **Helper** with many unrelated methods | The class may be doing too many things |
| Very large class (hundreds or thousands of lines) | Multiple responsibilities are likely mixed together |
| Class changes frequently for unrelated reasons | It has more than one reason to change |
| Methods belong to different domains (database, email, logging, business logic) | Responsibilities are not separated |
| Difficult to write unit tests | The class is handling too much |

---

# How to Identify Responsibilities

Whenever you design a class, ask yourself:

### Question 1

**What is the primary purpose of this class?**

If the answer contains "and",

it probably has multiple responsibilities.

Example:

> "This class registers users **and** sends emails."

Split it.

---

### Question 2

**How many different reasons can make this class change?**

If there are multiple unrelated reasons,

SRP is being violated.

---

### Question 3

**Can I describe this class in one sentence?**

Good example:

> "This class sends emails."

Bad example:

> "This class registers users, stores them in the database, logs activities, sends emails, and generates reports."

---

# Relationship with Other SOLID Principles

## SRP + OCP

Small, focused classes are easier to extend without modifying existing code.

---

## SRP + LSP

A parent class with only one responsibility is easier for child classes to honour correctly.

Focused base classes naturally support proper inheritance.

---

## SRP + ISP

When classes have one responsibility,

they usually implement only the interfaces they actually need.

---

## SRP + DIP

Small classes depending on abstractions create loosely coupled systems that are easier to maintain and test.

---

# Key Takeaways

- A class should have **only one responsibility**.
- A class should have **only one reason to change**.
- Separate unrelated responsibilities into different classes.
- Small, focused classes are easier to understand, test, reuse, and maintain.
- SRP is the foundation of clean object-oriented design.

---

# One-Line Summary

> **If a class changes for more than one reason, it has more than one responsibility and violates the Single Responsibility Principle.**
