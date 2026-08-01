

# Dependency Injection (DI)

Many developers confuse **Dependency Inversion Principle (DIP)** with **Dependency Injection (DI)**.

They are **not the same thing**.

- **DIP** is a **design principle**.
- **DI** is a **technique** used to achieve that principle.

Think of it like this:

| DIP | DI |
|-----|----|
| Design Principle | Implementation Technique |
| Says what good design looks like | Helps achieve that design |
| Part of SOLID | A feature supported by frameworks like Spring |

Simply remember:

> **Dependency Inversion is the goal. Dependency Injection is one way to achieve it.**

---

# What is Dependency Injection?

Instead of a class creating its own dependencies,

someone else provides them.

Without Dependency Injection:

```
OrderService

↓

creates

↓

MySQLDatabase
```

With Dependency Injection:

```
Main

↓

creates MySQLDatabase

↓

passes it to

↓

OrderService
```

The object no longer controls **how dependencies are created**.

It only uses them.

---

# Why Dependency Injection?

Imagine your OrderService does this:

```
MySQLDatabase database = new MySQLDatabase();
```

Problems:

- Cannot replace MySQL.
- Difficult to test.
- Tight coupling.
- Business logic controls infrastructure.

Instead,

someone else creates the database object and passes it to OrderService.

Now OrderService simply uses it.

---

# Types of Dependency Injection

Java commonly uses three types.

| Type | When to Use | Recommended |
|------|-------------|-------------|
| Constructor Injection | Required dependencies | ✅ Yes |
| Setter Injection | Optional dependencies | Sometimes |
| Interface Injection | Rarely used | ❌ No |

---

# Constructor Injection (Recommended)

Dependencies are provided through the constructor.

```
OrderService

↓

Constructor

↓

Database
```

Advantages:

- Required dependencies cannot be forgotten.
- Object is fully initialized.
- Easier testing.
- Immutable dependencies.
- Preferred by Spring Boot.

Whenever possible,

**always prefer Constructor Injection.**

---

# Setter Injection

Dependencies are provided using setter methods.

```
OrderService

↓

setDatabase(...)
```

Useful when:

- Dependency is optional.
- Dependency may change later.

Disadvantages:

- Object can exist in an incomplete state.
- Easier to misuse.

---

# Interface Injection

The dependency is supplied through an interface method.

Example idea:

```
inject(Database database)
```

Very uncommon in Java.

Spring Boot almost never uses it.

---

# Which Injection Should You Use?

| Situation | Best Choice |
|-----------|-------------|
| Required dependency | Constructor Injection |
| Optional dependency | Setter Injection |
| Spring Boot Services | Constructor Injection |
| Production applications | Constructor Injection |

If you are unsure,

choose **Constructor Injection**.

---

# Complete Working Example

We'll build a small order system.

The business logic should not know whether data is stored in:

- MySQL
- PostgreSQL

It should simply use a Database.

---

## Step 1 — Create the Abstraction

```
Database

save()

findById()
```

This interface defines **what** a database can do.

It says nothing about **how** it works.

---

## Step 2 — Implement MySQL

```
Database

↑

MySQLDatabase
```

MySQLDatabase provides the actual implementation.

---

## Step 3 — Implement PostgreSQL

```
Database

↑

PostgreSQLDatabase
```

Another implementation.

Notice that both satisfy the same abstraction.

---

## Step 4 — Database Service

Instead of exposing database implementations directly,

we create another service.

```
DatabaseService

↓

Database
```

DatabaseService depends on the abstraction,

not on MySQL or PostgreSQL.

---

## Step 5 — Order Service

```
OrderService

↓

DatabaseService

↓

Database
```

OrderService knows only one thing:

```
Save Order

Find Order
```

It has no idea whether the data is stored in

- MySQL
- PostgreSQL
- MongoDB

---

# Full Dependency Flow

```
Main

↓

creates

↓

MySQLDatabase

↓

passes into

↓

DatabaseService

↓

passes into

↓

OrderService
```

Notice something important.

Neither OrderService nor DatabaseService creates its own dependencies.

Everything is injected.

---

# Dependency Graph

```
                 Database
                (Interface)

                 ▲      ▲

                 │      │

      MySQLDatabase   PostgreSQLDatabase

                 ▲

                 │

          DatabaseService

                 ▲

                 │

            OrderService

                 ▲

                 │

                Main
```

Every dependency points toward the abstraction.

This is Dependency Inversion.

---

# Program Flow

Program starts.

↓

Main creates MySQLDatabase.

↓

Main passes MySQLDatabase to DatabaseService.

↓

DatabaseService receives Database.

↓

Main passes DatabaseService to OrderService.

↓

OrderService places an order.

↓

DatabaseService calls save().

↓

MySQLDatabase stores the data.

Notice that OrderService never mentions MySQL anywhere.

---

# Program Output

```
[OrderService] Placing order: Name:vishal

[MySQL] Saved record with id=1 data=Name:vishal

[OrderService] Order placed successfully. orderId=1

[MySQL] Fetching record with id=1

Order with orderId 1 is Name:vishal
```

Everything works.

---

# Switching Databases

Now suppose the company wants PostgreSQL.

Only one line changes.

Old:

```
Database database = new MySQLDatabase();
```

New:

```
Database database = new PostgreSQLDatabase();
```

Nothing else changes.

Not:

- OrderService

Not:

- DatabaseService

Not:

- Business logic

Only the implementation changes.

This is the biggest strength of DIP.

---

# Why Constructor Injection Is Better

Suppose OrderService requires a Database.

Without constructor injection,

someone may forget to initialize it.

```
OrderService service = new OrderService();

service.placeOrder();
```

Runtime error.

With constructor injection,

Java forces you to provide the dependency.

```
OrderService(databaseService);
```

Impossible to forget.

This makes applications safer.

---

# Spring Boot and Constructor Injection

Spring Boot strongly recommends Constructor Injection.

Example:

```
@Service

OrderService(Database database)
```

Spring automatically creates the Database implementation,

then injects it into OrderService.

The service never creates dependencies itself.

This is exactly how Spring implements Dependency Injection.

---

# Benefits of Dependency Injection

- Loose coupling
- Better readability
- Easier maintenance
- Easier testing
- Clear dependencies
- Safer object creation
- Better scalability
- Cleaner architecture

---

Definition

"High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions."

High-level vs Low-level modules
Type	Meaning	Example
High-level module	Contains business logic, orchestrates the flow	OrderService, NotificationService
Low-level module	Does the actual technical work	MySQLDatabase, EmailSender, SMSSender
The real meaning

Your business logic should never know or care which specific tool it is using. It should only know what the tool can do.

The dependency arrow should always point toward the abstraction — never from high-level directly to low-level.

Before DIP:
OrderService  →  MySQLDatabase
(high level)     (low level — tightly coupled)

After DIP:
OrderService  →  Database  ←  MySQLDatabase
(high level)  (abstraction)   (low level)

Both sides depend on the abstraction in the middle. Neither depends on each other. This is what "inversion" means.

Warning signs of violation
Signal	What it tells you
new ConcreteClass() inside a service or business class	Hard dependency on implementation
Changing infrastructure requires editing business logic	High and low level are tightly coupled
Cannot write a unit test without real infrastructure	No abstraction layer exists
Class imports full of concrete implementation names	Depending on details, not abstractions
Dependency Injection — the technique to achieve DIP

DIP is the principle. Dependency Injection is the technique used to implement it.

Type	When to use
Constructor Injection	Required dependencies — preferred approach
Setter Injection	Optional dependencies, changeable after creation
Interface Injection	Rare — uncommon in Java

Always prefer constructor injection — it makes dependencies explicit, visible, and forces the object to be fully ready at creation time.

Connection to other principles

DIP + SRP — each class has one job, so the abstraction it exposes is clean and focused.

DIP + OCP — new implementations plug in without modifying existing business logic.

DIP + LSP — any implementation of the abstraction can substitute another safely.

DIP + ISP — lean interfaces mean implementing classes are never burdened with unused methods.

SOLID is not five separate rules. It is one coherent design philosophy seen from five angles.





