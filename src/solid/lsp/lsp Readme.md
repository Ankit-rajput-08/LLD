# Liskov Substitution Principle (LSP)

## Definition

> **"Objects of a subclass should be substitutable for objects of the parent class without breaking the program."**

If **B extends A**, then everywhere an object of **A** is expected, an object of **B** should work correctly **without throwing unexpected exceptions, changing behaviour, or surprising the caller.**

Simply put:

> **A child class should be able to replace its parent without changing the correctness of the program.**

---

# The Real Meaning

LSP is a **quality check on inheritance**.

Inheritance is **not just about reusing code**.

When a child extends a parent, it is making a promise:

> **"I will honour everything my parent promised."**

LSP says:

> **That promise must never be broken.**

The parent defines a **contract**, and every child must follow that contract.

---

# Why LSP Exists

Many developers think:

> "If it is an 'is-a' relationship in real life, inheritance is correct."

Unfortunately, that is not true.

Programming inheritance is about **behaviour**, not categories.

LSP exists to ensure that inheritance creates **reliable polymorphism**, not runtime surprises.

---

# Two Types of "is-a"

| Type | Meaning |
|------|---------|
| **Categorical is-a** | Penguin is a Bird. Contract Employee is an Employee. (Real-world relationship) |
| **Behavioural is-a** | Can the child perform everything the parent promises in code? |

LSP only cares about **behavioural is-a**.

Just because something makes sense in English does **not** mean it should inherit from another class.

---

# Behavioural Contract

Every parent class defines a contract through its methods.

For example:

```
Vehicle

start()
stop()
move()
```

Any child extending `Vehicle` promises that these methods behave as expected.

The caller should never need to know which child object it received.

```
Vehicle vehicle = getVehicle();

vehicle.start();
vehicle.move();
vehicle.stop();
```

Whether `vehicle` is a Car, Bike or Bus should not matter.

That is true polymorphism.

---

# Why Behaviour Matters More Than Code

Imagine:

```
Bird
 ├── Sparrow
 ├── Eagle
 └── Penguin
```

A Bird has:

```
fly()
eat()
```

A Penguin cannot fly.

Although a Penguin **is a Bird** in real life,

it is **not a behavioural Bird** if the parent promises flying.

The hierarchy is wrong.

---

# Common Ways LSP Gets Violated

## 1. Throwing UnsupportedOperationException

```java
class Penguin extends Bird {

    @Override
    public void fly() {
        throw new UnsupportedOperationException();
    }
}
```

The child cannot honour the parent's promise.

This is the most common LSP violation.

---

## 2. Changing Expected Behaviour

```java
class ContractEmployee extends Employee {

    @Override
    public void applyLeave() {
        // does nothing
    }
}
```

The caller expected leave to be applied.

Instead, nothing happens.

The contract has been silently broken.

---

## 3. Using instanceof Before Calling Methods

```java
if(employee instanceof FullTimeEmployee){
    employee.applyLeave();
}
```

Whenever you need `instanceof` to decide whether calling a method is safe,

your inheritance hierarchy is broken.

The caller should never care about the concrete child.

---

## 4. Returning Dummy Values

```java
public double calculateBonus() {
    return 0;
}
```

Returning fake values simply to satisfy the parent contract is another warning sign.

---

## 5. Empty Overridden Methods

```java
@Override
public void save() {
    // Do nothing
}
```

The child is pretending to support behaviour that it actually doesn't.

---

# Example 1 — Bird and Penguin

## ❌ Bad Design

```
Bird
├── fly()
└── eat()

        ▲
        │
    Penguin
```

The parent promises:

```
fly()
```

Penguin cannot fly.

So developers write

```java
throw new UnsupportedOperationException();
```

Now the program crashes whenever a Penguin is passed.

---

## Runtime Problem

```
Bird bird = new Penguin();

bird.fly();
```

Result:

```
UnsupportedOperationException
```

Polymorphism is broken.

---

## ✅ Better Design

Split the hierarchy.

```
Bird
│
├── FlyingBird
│      ├── Sparrow
│      ├── Eagle
│      └── Parrot
│
└── NonFlyingBird
       ├── Penguin
       └── Ostrich
```

Now only FlyingBird promises:

```
fly()
```

Compile-time safety is restored.

---

# Example 2 — Employee and ContractEmployee

## ❌ Bad Design

```
Employee

applyLeave()

        ▲
        │
ContractEmployee
```

Contract employees don't receive paid leave.

Developers often write

```java
throw new UnsupportedOperationException();
```

or

```java
// do nothing
```

Both violate LSP.

---

## Runtime Problem

```
Employee employee = new ContractEmployee();

employee.applyLeave();
```

The HR module behaves incorrectly.

---

## ✅ Better Design

Split responsibilities.

```
Employee
(name, salary)

        │
        ├──────────────┐
        │              │
LeaveEligibleEmployee  ContractEmployee
```

```
LeaveEligibleEmployee
│
├── FullTimeEmployee
└── InternEmployee
```

Only eligible employees promise leave functionality.

Every child now honours its parent.

---

# Example 3 — Payment System

## ❌ Bad Design

```
PaymentMethod

refund()

        ▲
        │
GiftCard
```

Suppose Gift Cards cannot be refunded.

Developers write

```java
throw new UnsupportedOperationException();
```

Bad inheritance.

---

## ✅ Better Design

```
PaymentMethod

Refundable
```

Only payment methods supporting refunds implement `Refundable`.

---

# Example 4 — Storage System

## ❌ Bad Design

```
Storage

read()
write()

        ▲
        │
ReadOnlyStorage
```

Developers override

```
write()
```

to throw an exception.

Again,

the child broke the parent's contract.

---

## ✅ Better Design

```
ReadableStorage

WritableStorage
```

Capabilities are separated.

---

# Warning Signs of LSP Violation

| Signal | What It Means |
|----------|---------------|
| `UnsupportedOperationException` | Child cannot honour the parent's contract |
| `instanceof` before calling methods | Inheritance hierarchy is wrong |
| Child changes expected behaviour | Contract has been broken |
| Empty overridden methods | Fake implementation |
| Returning dummy values | Behaviour is inconsistent |
| Different semantics in overridden method | Parent promise no longer valid |

---

# The Fix Strategy

Whenever you discover an LSP violation, ask these questions.

---

## 1. Can every child honour every parent method?

If not,

the parent class is modelling too much.

Split it.

---

## 2. What do ALL children genuinely share?

Move only that into the parent.

---

## 3. What do only SOME children share?

Create:

- an intermediate abstract class

or

- a separate interface

Only eligible children should inherit it.

---

## 4. Does every child behave exactly as callers expect?

If yes,

your hierarchy satisfies LSP.

---

# LSP and Polymorphism

Good polymorphism means

```
Parent parent = getObject();

parent.method();
```

works correctly regardless of which child is returned.

If callers must check

```
instanceof
```

or

```
getClass()
```

before calling methods,

polymorphism has failed.

---

# LSP in Java

Java follows LSP extensively.

Examples include:

```
List
```

implemented by

- ArrayList
- LinkedList
- Vector

Any List implementation should behave according to the List contract.

Similarly,

```
Queue
```

is implemented by

- LinkedList
- PriorityQueue
- ArrayDeque

Callers work with the abstraction,

not the implementation.

---

# Relationship with Other SOLID Principles

## LSP + SRP

A parent class with too many responsibilities makes it difficult for every child to honour all behaviours.

Keeping classes focused through SRP naturally improves LSP.

---

## LSP + OCP

Open/Closed Principle encourages extending behaviour through inheritance or polymorphism.

LSP ensures those new subclasses do not break existing code.

Without LSP,

OCP cannot work reliably.

---

## LSP + ISP

ISP is essentially LSP applied to interfaces.

Instead of forcing subclasses,

ISP prevents forcing implementing classes into contracts they cannot fulfil.

Both principles promote honest contracts.

---

## LSP + DIP

Dependency Inversion relies on abstractions.

For abstractions to be useful,

every implementation must behave consistently.

LSP guarantees that consistency.

---

# Benefits of Following LSP

- Safe inheritance
- Reliable polymorphism
- Better maintainability
- Easier testing
- Cleaner APIs
- Fewer runtime errors
- Less defensive programming
- Better extensibility

---

# Common Interview Questions

### What is the Liskov Substitution Principle?

Objects of a subclass should be replaceable with objects of the parent class without affecting program correctness.

---

### What is the biggest sign of an LSP violation?

`UnsupportedOperationException` in an overridden method.

---

### Why is `instanceof` often considered an LSP smell?

Because callers should not need to know the concrete child type before calling methods.

---

### Is every real-world "is-a" relationship suitable for inheritance?

No.

Only behavioural "is-a" relationships should use inheritance.

---

### What is the difference between categorical and behavioural inheritance?

Categorical inheritance reflects the real world.

Behavioural inheritance reflects the behaviour expected by software.

LSP only cares about behavioural inheritance.

---

### How do you fix an LSP violation?

Split the hierarchy so that only classes capable of fulfilling a contract inherit that contract.

---

# Quick Checklist

Before creating inheritance, ask:

- Can every child honour every parent method?
- Will polymorphism work without `instanceof`?
- Will no child throw `UnsupportedOperationException`?
- Will callers receive consistent behaviour?
- Is the parent defining only shared behaviour?

If all answers are **Yes**, your inheritance likely satisfies LSP.

---

# Key Takeaways

- Inheritance is about **behaviour**, not code reuse.
- Every child must honour the parent's contract.
- Never fake behaviour using exceptions or empty methods.
- If replacing a parent with a child changes program correctness, the hierarchy is wrong.
- Design hierarchies around **shared behaviour**, not real-world categories.

---

# One-Line Rule to Remember

> **If substituting a child for a parent surprises the caller, your inheritance is wrong. A child must preserve the parent's behaviour—not just inherit its methods.**
