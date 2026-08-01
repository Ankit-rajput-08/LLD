# Interface Segregation Principle (ISP)

## Definition

> **"A class should not be forced to implement interfaces it does not use."**

Don't create one large interface and force every class to implement all of it. Break it into smaller, focused interfaces so each class only implements what is actually relevant to it.

---

# The Real Meaning

ISP is about **honest contracts**.

When a class implements an interface, it is making a promise:

> **"I can do everything this interface defines."**

ISP says:

> **Never put a class in a position where it has to make a promise it cannot keep.**

---

# Connection to LSP

| LSP | ISP |
|-----|-----|
| Child class forced to inherit methods it cannot honour | Implementing class forced to implement methods it doesn't need |
| Problem at the inheritance level | Problem at the interface level |
| Fix → Restructure class hierarchy | Fix → Split the interface |

Although they solve problems at different layers, they share the same root cause:

> **A class is forced into a contract it cannot fully satisfy.**

If you frequently see `UnsupportedOperationException` in a codebase, it is often an indication of an **LSP or ISP violation**.

---

# Why ISP Exists

Large interfaces eventually become difficult to maintain.

When new methods are added:

- unrelated classes break
- fake implementations appear
- empty methods are written
- testing becomes harder
- mocking becomes painful

Instead of one interface doing everything, divide it into interfaces representing individual capabilities.

---

# Common Signs of an ISP Violation

## 1. UnsupportedOperationException

```java
class RobotWorker implements WorkerActions {

    @Override
    public void eat() {
        throw new UnsupportedOperationException("Robots don't eat");
    }
}
```

The class is forced to implement behaviour it doesn't support.

---

## 2. Empty Method Body

```java
class BasicPrinter implements Machine {

    @Override
    public void fax() {
        // Do nothing
    }
}
```

The method exists only to satisfy the compiler.

---

## 3. Adding One Method Breaks Many Classes

Suppose you add

```java
exportToPDF();
```

to

```java
interface Reportable
```

Suddenly many classes that only generate CSV reports fail to compile.

This indicates the interface is too broad.

---

## 4. Fat Interface Names

Interface names like:

- Manager
- Handler
- Processor
- Utility
- Helper

are often warning signs.

Such names usually hide multiple responsibilities.

---

# Example 1 — Worker System

## ❌ Bad Design

```
WorkerActions
├── work()
├── attendMeeting()
├── eat()
├── sleep()
└── claimExpenses()
```

### HumanEmployee

Needs every method.

### RobotWorker

Needs only:

- work()
- attendMeeting()

But is forced to implement:

- eat()
- sleep()
- claimExpenses()

This is an ISP violation.

---

## ✅ Good Design

Split by capability.

```
Workable
├── work()
└── attendMeeting()

Biological
├── eat()
└── sleep()

Claimable
└── claimExpenses()
```

Now

```
HumanEmployee
implements
- Workable
- Biological
- Claimable
```

```
RobotWorker
implements
- Workable
```

Every class implements only what it actually supports.

---

# Example 2 — Printer System

## ❌ Bad Design

```
Machine
├── print()
├── scan()
├── fax()
└── photocopy()
```

A simple printer only prints.

Yet it must implement:

- scan()
- fax()
- photocopy()

Usually resulting in empty methods or exceptions.

---

## ✅ Good Design

Split the interface.

```
Printable
└── print()

Scannable
└── scan()

Faxable
└── fax()

Photocopiable
└── photocopy()
```

Now

```
BasicPrinter
implements Printable
```

```
AllInOnePrinter
implements

Printable
Scannable
Faxable
Photocopiable
```

Each implementation promises only what it can actually perform.

---

# How to Split a Fat Interface

Whenever you see a large interface, ask these questions.

## 1. Can I describe this interface in one phrase?

If not,

it probably has multiple responsibilities.

---

## 2. Which methods naturally belong together?

Group related methods.

Each group becomes its own interface.

---

## 3. Would a future implementation need fake methods?

If yes,

split the interface before adding that class.

---

## 4. Does each interface represent one capability?

If yes,

your interface design is likely correct.

---

# ISP in Java Standard Library

Java follows ISP extensively.

| Instead of | Java Uses |
|------------|-----------|
| One giant stream interface | `Readable`, `Appendable`, `Closeable` |
| One giant collection interface | `Iterable → Collection → List` |
| One giant I/O class | `InputStream`, `OutputStream`, `Reader`, `Writer` |

This allows classes to implement only the capabilities they actually provide.

---

# Access Modifiers Inside Interfaces

| Member | Default | Can Change? |
|---------|----------|------------|
| Abstract method | `public abstract` | ❌ No |
| Default method | `public` | ❌ No |
| Static method | `public` | ❌ No |
| Private method | `private` | Already explicit |
| Fields | `public static final` | ❌ No |

---

# Important Rules

### Abstract methods cannot be private.

A private method cannot be implemented by another class.

Therefore an abstract private method is meaningless.

---

### Use default methods sparingly.

They exist to share common behaviour.

Too many default methods usually indicate that the interface is becoming bloated.

---

### Don't use interfaces as constant holders.

Avoid this:

```java
interface Constants {
    int MAX = 100;
}
```

Prefer:

```java
final class Constants {

    private Constants() {}

    public static final int MAX = 100;
}
```

---

# Warning Signs Summary

| Signal | Meaning |
|----------|---------|
| UnsupportedOperationException | Forced contract that cannot be honoured |
| Empty method body | Forced implementation |
| Interface called Manager/Handler/Processor | Likely too broad |
| One new method breaks many classes | Interface is bloated |
| Only one class implements a huge interface | Poor abstraction |

---

# Relationship with Other SOLID Principles

## ISP + LSP

ISP prevents many LSP violations.

Smaller interfaces ensure implementing classes never fake behaviour.

---

## ISP + SRP

A fat interface usually means the abstraction itself has multiple responsibilities.

Splitting interfaces mirrors how SRP splits classes.

---

## ISP + DIP

Lean interfaces make dependency injection simpler.

Benefits include:

- easier mocking
- easier testing
- easier replacement of implementations
- reduced coupling

---

# Benefits of ISP

- Smaller interfaces
- Honest contracts
- Better maintainability
- Easier testing
- Less coupling
- Easier extension
- Cleaner architecture
- Fewer runtime surprises

---

# Quick Interview Questions

### What is ISP?

A class should not be forced to implement interfaces it does not use.

---

### Why is ISP important?

It prevents unnecessary implementations, reduces coupling, and creates smaller, more maintainable interfaces.

---

### What is a fat interface?

An interface containing unrelated methods that many implementations don't need.

---

### How do you identify an ISP violation?

Common signs include:

- `UnsupportedOperationException`
- Empty method bodies
- Frequent breaking changes when adding interface methods
- Large interfaces with unrelated responsibilities

---

### How is ISP related to LSP?

LSP focuses on inheritance.

ISP focuses on interfaces.

ISP helps prevent many LSP violations by ensuring classes implement only behaviours they genuinely support.

---

### What is the biggest benefit of ISP?

Each class depends only on the capabilities it actually needs.

---

# Key Takeaways

- Prefer **many small, focused interfaces** over one large interface.
- Every interface should represent **one capability**.
- Never force implementations to fake behaviour.
- Small interfaces are easier to test, mock, extend, and maintain.
- ISP produces cleaner APIs and reduces unnecessary coupling.

---

# One-Line Rule to Remember

> **Many small, focused interfaces are better than one large bloated interface. Every interface should represent one capability—not a collection of unrelated abilities.**
