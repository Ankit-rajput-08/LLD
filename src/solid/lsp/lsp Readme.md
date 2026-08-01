# Liskov Substitution Principle (LSP)

## Definition

> **"Objects of a subclass should be substitutable for objects of the parent class without breaking the program."**

In other words:

> If **B extends A**, then **everywhere A is used, B should work correctly** — no exceptions thrown, no broken behaviour, and no surprises for the caller.

---

# The Real Meaning

LSP is a **quality check on inheritance**.

Inheritance is **not just about reusing code**.

When a child class extends a parent class, it is making a promise:

> **"I will honour everything my parent promised."**

LSP says that **this promise must never be broken**.

---

# Two Types of "is-a" — The Core Trap

| Type | Meaning |
|------|---------|
| **Categorical is-a** | Penguin is a Bird. ContractEmployee is an Employee. (Real-world relationship) |
| **Behavioural is-a** | Can this child actually do everything the parent promised in code? |

> **LSP only cares about behavioural "is-a".**

Real-world categories often lead developers into incorrect inheritance hierarchies.

> **Just because something makes sense in English doesn't mean it makes sense as inheritance.**

---

# How LSP Violations Happen

A parent class makes a **contract** through its methods.

The child class violates that contract in one of the following ways.

---

## 1. Throwing an Exception for an Inherited Method

### ❌ Bad Example

```java
class Penguin extends Bird {

    @Override
    public void fly() {
        throw new UnsupportedOperationException();
    }
}
