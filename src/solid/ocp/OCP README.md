# Open/Closed Principle (OCP)

## Definition

> **"Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification."**

This means:

- **Open for Extension** → You should be able to add new behaviour.
- **Closed for Modification** → You should not have to change existing, tested code.

Instead of modifying working classes every time a new requirement arrives, create new classes that extend the existing behaviour.

---

# The Real Meaning

OCP is about **protecting stable code**.

Every time you modify an existing class, you introduce the possibility of new bugs.

OCP says:

> **Once a class has been tested and is working correctly, avoid changing it. Extend it instead.**

Think of existing code as a finished building.

Instead of breaking walls every time a new room is needed, build an extension.

---

# Why OCP Exists

Software changes constantly.

Customers request:

- new payment methods
- new notification channels
- new discount types
- new report formats
- new shipping partners

If every new feature requires editing old classes, the project becomes difficult to maintain.

OCP minimizes that risk.

---

# The Core Idea

Bad design:

```
Requirement changes
        ↓
Modify existing class
        ↓
Retest everything
        ↓
Risk introducing bugs
```

Good design:

```
Requirement changes
        ↓
Create new class
        ↓
Existing code remains untouched
        ↓
Lower risk
```

---

# Open vs Closed

| Open | Closed |
|------|---------|
| Can add new behaviour | Existing code doesn't change |
| Supports future requirements | Stable code remains protected |
| Extension through inheritance, interfaces or composition | Avoid editing tested classes |

Being "closed" does **not** mean the class can never change.

It means that **after it becomes stable**, future features should ideally be added without modifying it.

---

# Why Modifying Existing Code Is Dangerous

Imagine a payment service.

Today it supports:

- Credit Card
- UPI

Tomorrow,

the business asks for

- PayPal

A poor design edits the payment class.

```
PaymentService
```

gets modified.

Now there is a chance of breaking:

- Credit Card
- UPI

even though they were already working.

---

# Common Ways OCP Gets Violated

## 1. Large if-else Chains

```java
if(type.equals("CARD")){
    ...
}
else if(type.equals("UPI")){
    ...
}
else if(type.equals("PAYPAL")){
    ...
}
```

Every new type requires editing the same class.

---

## 2. Massive switch Statements

```java
switch(notificationType){

EMAIL

SMS

PUSH

WHATSAPP

SLACK

...
}
```

The switch keeps growing.

---

## 3. One Class Knows Every Business Rule

```
OrderService

calculateDiscount()

processPayment()

sendNotification()

generateInvoice()

...
```

Every new feature modifies the same class.

---

## 4. Existing Classes Keep Changing

If one class changes every sprint,

it is probably violating OCP.

---

# Example 1 — Payment System

## ❌ Bad Design

```
PaymentService

processPayment(type)
```

Inside:

```
if CARD

if UPI

if WALLET

if PAYPAL

if NETBANKING
```

Every payment method requires modifying this class.

---

## Problems

- Huge if-else chain
- Difficult testing
- Merge conflicts
- High bug risk
- Violates OCP

---

## ✅ Better Design

```
PaymentMethod

process()
```

Implementations

```
PaymentMethod
│
├── CardPayment
├── UpiPayment
├── WalletPayment
├── PaypalPayment
└── NetBankingPayment
```

PaymentService depends only on

```
PaymentMethod
```

Adding Apple Pay?

Simply create

```
ApplePayPayment
```

No existing class changes.

---

# Example 2 — Notification System

## ❌ Bad Design

```
NotificationService

send(type)
```

```
if EMAIL

if SMS

if PUSH

if WHATSAPP

if SLACK
```

Every notification channel edits the same method.

---

## ✅ Better Design

```
Notification

send()
```

```
Notification
│
├── EmailNotification
├── SmsNotification
├── PushNotification
├── WhatsappNotification
└── SlackNotification
```

Adding Telegram?

Create

```
TelegramNotification
```

Nothing else changes.

---

# Example 3 — Discount System

## ❌ Bad Design

```
calculateDiscount(customerType)
```

```
Regular

Premium

Gold

VIP

Student

Employee

Festival

...
```

Every new discount modifies the same class.

---

## ✅ Better Design

```
DiscountStrategy
```

```
DiscountStrategy
│
├── RegularDiscount
├── PremiumDiscount
├── GoldDiscount
├── VipDiscount
└── StudentDiscount
```

Each strategy knows only its own calculation.

---

# Example 4 — Report Generation

## ❌ Bad Design

```
generateReport(format)
```

```
if PDF

if CSV

if EXCEL

if XML

if JSON
```

---

## ✅ Better Design

```
ReportGenerator
│
├── PdfReport
├── CsvReport
├── ExcelReport
├── JsonReport
└── XmlReport
```

Adding Word export means creating

```
WordReport
```

without touching old code.

---

# Warning Signs of OCP Violation

| Signal | What It Means |
|----------|---------------|
| Growing if-else chains | Every feature edits existing code |
| Massive switch statements | Behaviour is tightly coupled |
| One class changes every sprint | Class isn't closed for modification |
| Frequent merge conflicts | Too many developers edit the same file |
| New feature requires editing many classes | Design is rigid |

---

# The Fix Strategy

Whenever you need to modify an existing class, ask:

---

## 1. Is the behaviour likely to grow?

If yes,

don't hardcode it.

Create an abstraction.

---

## 2. What is changing?

Only the changing behaviour should become an interface or abstract class.

---

## 3. What remains stable?

Keep stable code untouched.

---

## 4. Can future behaviour be added using new classes?

If yes,

your design likely follows OCP.

---

# OCP and Polymorphism

Polymorphism is one of the biggest tools for achieving OCP.

Instead of

```
if(type=="EMAIL")
```

let polymorphism decide.

```
Notification notification = ...

notification.send();
```

The caller doesn't care which implementation is used.

---

# OCP in Java

Java follows OCP extensively.

Examples include:

```
Comparator
```

Need a new sorting rule?

Create another Comparator.

No existing collection class changes.

---

```
Runnable
```

Need another task?

Implement Runnable.

No Thread class changes.

---

```
List
```

Need another list implementation?

Create one.

Existing List users continue working.

---

# Relationship with Other SOLID Principles

## OCP + SRP

Classes with one responsibility are much easier to extend.

SRP prepares classes for OCP.

---

## OCP + LSP

OCP often uses inheritance or polymorphism.

LSP ensures new subclasses don't break existing behaviour.

Without LSP,

OCP cannot work safely.

---

## OCP + ISP

Small interfaces make extensions easier.

Large interfaces make adding implementations difficult.

---

## OCP + DIP

Dependency Inversion makes OCP practical.

High-level modules depend on abstractions,

allowing new implementations without modifying business logic.

---

# Benefits of Following OCP

- Easier maintenance
- Lower bug risk
- Better scalability
- Cleaner architecture
- Better extensibility
- Easier testing
- Reduced merge conflicts
- Better team collaboration

---

# Common Interview Questions

### What is the Open/Closed Principle?

Software entities should be open for extension but closed for modification.

---

### Why is OCP important?

It allows new functionality to be added without changing stable, tested code.

---

### How is OCP achieved?

Usually through:

- Interfaces
- Abstract classes
- Polymorphism
- Composition
- Strategy Pattern
- Factory Pattern

---

### Does OCP mean code can never change?

No.

It means stable code should ideally not require modification for every new feature.

---

### Why are if-else chains considered an OCP violation?

Because every new behaviour requires modifying existing code.

---

### What design patterns commonly support OCP?

- Strategy
- Factory
- Command
- Decorator
- Template Method
- Observer

---

# Quick Checklist

Before modifying a class, ask:

- Will new behaviour arrive in the future?
- Can I extend instead of edit?
- Can polymorphism remove this if-else chain?
- Can an interface represent the changing behaviour?
- Will existing tested code remain untouched?

If all answers are **Yes**, your design likely follows OCP.

---

# Key Takeaways

- Extend behaviour instead of modifying working code.
- Stable code should remain stable.
- Replace growing if-else chains with polymorphism.
- Use interfaces and abstractions for changing behaviour.
- OCP reduces bugs, improves scalability, and makes software easier to maintain.

---

# One-Line Rule to Remember

> **Don't keep changing working code for every new requirement. Design your software so new behaviour is added through new classes, not by modifying existing ones.**
