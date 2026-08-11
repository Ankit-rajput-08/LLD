UML Diagrams — Class & Sequence Diagrams



1. What is UML?

UML = Unified Modeling Language.

UML is a visual language used to represent software systems through diagrams.

Instead of explaining an application only with long paragraphs, we can use diagrams to communicate:

What classes exist

What objects exist

How classes are related

How objects communicate

How a particular use case flows

For LLD interviews, UML is especially useful because it lets us communicate a design before writing the complete implementation.

2. Why Use UML?

Suppose an interviewer asks:

"Design a food delivery application."

Explaining the entire design verbally can become confusing.

A diagram can immediately show:

Customer
   |
   v
Order ----> Restaurant
   |
   v
Payment

UML therefore helps us:

Visualize the design.

Communicate ideas clearly.

Identify relationships between classes.

Understand object interactions.

Discuss a design before coding it.

Explain an LLD solution during interviews.

3. Types of UML Diagrams

UML diagrams can broadly be divided into:

                    UML
                     |
          +----------+----------+
          |                     |
     Structural             Behavioral
       Diagrams              Diagrams
          |                     |
      Static view          Dynamic view

Structural Diagrams

Structural diagrams describe what exists in the system.

Examples include:

Class Diagram

Object Diagram

Component Diagram

Deployment Diagram

Package Diagram

Composite Structure Diagram

Profile Diagram

The important idea:

Structural diagrams describe the static structure of a system.

Behavioral Diagrams

Behavioral diagrams describe how the system behaves or how objects interact.

Examples include:

Sequence Diagram

Activity Diagram

Use Case Diagram

State Machine Diagram

Communication Diagram

Interaction Overview Diagram

Timing Diagram

The important idea:

Behavioral diagrams describe dynamic behavior.

4. Most Important UML Diagrams for LLD

For LLD interviews, two diagrams are particularly useful:

Class Diagram
     +
Sequence Diagram

Class Diagram

Answers:

What classes are present and how are they related?

Sequence Diagram

Answers:

How do objects interact with each other for a particular use case?

Think:

Class Diagram
    =
Structure

Sequence Diagram
    =
Behavior / Flow

5. Class Diagram

A class diagram represents:

Classes

Attributes

Methods

Relationships

Access modifiers

Inheritance

Associations

A class is normally represented as a rectangle divided into three sections:

+----------------------------+
|            Car             |
+----------------------------+
| - brand : String           |
| - model : String           |
| - engineCC : Integer       |
+----------------------------+
| + startEngine() : void     |
| + stopEngine() : void      |
| + accelerate() : void      |
| + brake() : void           |
+----------------------------+

The three sections are:

1. Class name
2. Attributes / variables
3. Methods / behaviors

6. Class Name

The first section contains the class name.

Example:

+----------------+
|      Car       |
+----------------+

This represents:

class Car {
}

7. Attributes

Attributes represent the data/state of an object.

Example:

brand : String
model : String
engineCC : Integer

Equivalent Java:

class Car {

    private String brand;
    private String model;
    private Integer engineCC;
}

UML notation generally follows:

visibility variableName : DataType

Example:

- brand : String

8. Methods

Methods represent behavior.

Example:

+ startEngine() : void
+ stopEngine() : void
+ accelerate() : void
+ brake() : void

Equivalent Java:

public void startEngine() {
}

public void stopEngine() {
}

public void accelerate() {
}

public void brake() {
}

General UML notation:

visibility methodName(parameters) : returnType

Example:

+ calculatePrice(quantity : int) : double

9. Access Modifiers in UML

UML uses symbols for visibility.

Symbol

Access

Meaning

+

public

Accessible from anywhere

-

private

Accessible only inside the class

#

protected

Accessible by class/subclasses

~

package/default

Accessible within package

Example:

+ publicMethod()
- privateMethod()
# protectedMethod()
~ packageMethod()

10. Encapsulation in UML

A good OOP design normally keeps internal data private.

Example:

+---------------------------+
|          Car              |
+---------------------------+
| - brand : String          |
| - model : String          |
| - engineCC : Integer      |
+---------------------------+
| + startEngine() : void    |
| + accelerate() : void     |
+---------------------------+

The attributes are private:

-

while required behaviors are exposed publicly:

+

This represents encapsulation.

11. Abstract Class in UML

An abstract class represents a class that is intended to be inherited rather than directly instantiated.

Conceptually:

       <<abstract>>
          Animal
             ^
             |
       +-----+-----+
       |           |
      Cow         Tiger

An abstract class can be represented by:

<<abstract>>
Animal

or by using an italicized class name in standard UML notation.

Example:

abstract class Animal {

    abstract void makeSound();
}

12. Concrete Class

A concrete class can be instantiated.

Example:

Car

Equivalent:

Car car = new Car();

So:

Abstract Class
    |
    +--> used as abstraction

Concrete Class
    |
    +--> can create objects

13. Associations

An association represents a relationship between classes/objects.

Example:

Customer -------- Order

Meaning:

Customer is associated with Order

Associations are important because LLD is mainly about designing objects and their relationships.

14. Class Association vs Object Association

There are two useful ways to think about association:

Class-level

Customer -------- Order

This says the classes are related.

Object-level

customer1 -------- order101

This describes a relationship between actual runtime objects.

15. Inheritance

Inheritance represents an IS-A relationship.

Example:

              Animal
                 ^
                 |
       +---------+---------+
       |                   |
      Cow                 Tiger

Meaning:

Cow IS-A Animal
Tiger IS-A Animal

Java:

class Animal {
    void eat() {}
}

class Cow extends Animal {
    void moo() {}
}

The child inherits behavior/state from the parent.

16. Inheritance in UML

The inheritance relationship is represented using a line with a hollow/closed triangular arrowhead pointing toward the parent.

Conceptually:

Cow -------------▷ Animal

The arrow points toward the superclass.

Remember:

The arrow points to the parent.

17. Composition vs Inheritance

This is one of the most important ideas for LLD.

Inheritance:

IS-A

Composition/association:

HAS-A

Example:

Car IS-A Vehicle

but:

Car HAS-A Engine

So:

        Vehicle
           ^
           |
          Car
           |
           | has-a
           v
         Engine

In LLD, composition is often preferred when the relationship is genuinely "has-a".

18. Three Important Object Relationships

The video explains three commonly discussed "has-a" relationships:

1. Simple Association
2. Aggregation
3. Composition

They differ mainly in ownership and lifecycle dependency.

19. Simple Association

Simple association is the weakest relationship.

Example:

Arjun -------- House

Conceptually:

Arjun has/lives in a House

The two objects are related, but neither object necessarily owns the lifecycle of the other.

If Arjun stops living in the house:

Arjun

can still exist.

The house can also exist independently.

20. UML Representation of Association

Conceptually:

Arjun ----------> House

An open arrow can indicate navigability.

The important point is:

Association
=
objects are related

but there is no strong ownership requirement.

21. Aggregation

Aggregation represents a stronger "whole-part" relationship.

Example:

Room
 |
 +---- Bed
 +---- Chair
 +---- Sofa

The room contains these objects.

However:

Bed
Chair
Sofa

can still exist independently of the room.

For example, a chair can be moved from one room to another.

So:

Room
  |
  +---- Chair

does not mean the chair's existence depends entirely on that room.

22. UML Representation of Aggregation

Aggregation is commonly represented using a hollow diamond.

Conceptually:

Room ◇---------- Chair

The diamond is placed on the side of the aggregate/whole.

Think:

Whole ◇-------- Part

23. Composition

Composition is the strongest whole-part relationship.

The child/part is strongly owned by the parent.

Example:

Chair
 |
 +---- Seat
 +---- ArmRest
 +---- Wheels

If those parts are modeled as components that belong specifically to the chair, their lifecycle is tied to the chair.

Conceptually:

Chair ◆---------- Seat

A filled diamond represents composition.

24. Aggregation vs Composition

This distinction is extremely important.

Property

Aggregation

Composition

Relationship

Has-a

Has-a

Ownership

Weak

Strong

Child independent?

Usually yes

Usually no

Lifecycle dependency

Weak

Strong

UML symbol

Hollow diamond

Filled diamond

Easy example

Aggregation:

Room ◇---- Chair

A chair can move to another room.

Composition:

House ◆---- Room

If rooms are modeled as parts belonging to that house, their lifecycle is tied to the house.

25. The Most Important Question

When deciding between inheritance and composition, ask:

Is-A?

Cow IS-A Animal

Use inheritance when the subtype relationship genuinely makes sense.

Has-A?

Car HAS-A Engine

Use composition/association.

This simple question helps avoid unnecessary inheritance.

26. Composition in Code

Composition is generally implemented using object references.

Example:

class A {

    void methodOne() {
    }
}

class B {

    private A a;

    B() {
        a = new A();
    }

    void methodTwo() {
        a.methodOne();
    }
}

Here:

B
 |
 +---- A

B contains a reference to A.

This is fundamentally different from:

class B extends A {
}

which represents inheritance.

27. Composition Is Very Important in LLD

A common LLD mistake is trying to solve every relationship with inheritance.

Instead of:

A
^
|
B

many real designs are better represented as:

B
|
+---- A

This is the fundamental idea behind:

Favor composition over inheritance.

Composition gives flexibility because behavior can often be delegated to contained objects.

28. Association vs Aggregation vs Composition

A practical mental model:

Association
    |
    |-- "I know/relate to this object"

Aggregation
    |
    |-- "I contain this object,
    |    but it can live independently"

Composition
    |
    |-- "I strongly own this object;
         its lifecycle belongs to me"

29. Real-World Example — Restaurant and Menu

Consider a food-delivery application.

Restaurant
    |
    +---- MenuItem

Now ask:

Can a MenuItem exist independently from the Restaurant?

The answer depends on how we model the domain.

Option 1 — Aggregation

If menu items are independent entities:

Restaurant ◇---- MenuItem

A menu item can exist separately and potentially move between restaurant menus.

Option 2 — Composition

If menu items are created exclusively as part of the restaurant's menu and have no independent lifecycle:

Restaurant ◆---- MenuItem

Then composition may be more appropriate.

Important: UML relationship decisions are design decisions. The same real-world concept can be modeled differently depending on application requirements.

30. Sequence Diagram

A sequence diagram represents:

How objects communicate over time for a particular use case.

Class diagram:

What exists?

Sequence diagram:

What happens?

Example:

User        ATM       Account
 |           |           |
 | withdraw  |           |
 |---------->|           |
 |           | check     |
 |           |---------->|
 |           |<----------|
 |           | dispense  |
 |<----------|           |

31. Class Diagram vs Sequence Diagram

Class Diagram

Sequence Diagram

Static structure

Dynamic behavior

Classes

Objects

Attributes

Messages

Methods

Interaction flow

Relationships

Time/order

System architecture

Use-case execution

Easy memory:

CLASS
=
STRUCTURE

SEQUENCE
=
FLOW

32. Basic Sequence Diagram Components

Important components include:

1. Object
2. Lifeline
3. Activation bar
4. Message
5. Return message

33. Object in Sequence Diagram

A sequence diagram focuses on objects participating in a particular interaction.

Example:

User
ATM
Account
Transaction
CashDispenser

Unlike a class diagram, we are interested in runtime participants.

34. Lifeline

A lifeline shows the existence of an object during the interaction.

Conceptually:

User
 |
 |
 |
 |
 |

The vertical dashed line represents the object's lifetime.

Multiple objects:

User             ATM             Account
 |                |                |
 |                |                |
 |                |                |
 |                |                |

Time generally progresses from top to bottom.

35. Activation Bar

An activation bar shows when an object is actively executing/processing an operation.

Conceptually:

User             ATM
 |                |
 |                |
 |              [===]
 |              [===]
 |              [===]
 |                |

The bar represents the period during which the object is active.

36. Messages

Messages represent communication between objects.

Example:

User ---------> ATM
       withdraw()

The sender sends a request to the receiver.

The ordering of messages represents the sequence of execution.

37. Synchronous Message

A synchronous call means:

The sender waits for the receiver to complete/respond before continuing.

Example:

A ---------> B
      call
A <--------- B
      response

Conceptually:

A
 |
 |-------> B
 |         |
 |         | process
 |<--------|
 |
continue

This resembles a normal method call.

38. Return Message

A return/response can be represented using a dashed line.

Example:

A ---------> B
A <--------- B

The second line represents the response.

39. Asynchronous Message

An asynchronous message means:

The sender does not have to wait for the receiver before continuing.

Conceptually:

A ---------> B
 |
 | continue
 v
next operation

This is common in systems involving:

Events

Message queues

Notifications

Background processing

Kafka-style communication

40. Synchronous vs Asynchronous

Synchronous

Asynchronous

Sender waits

Sender does not wait

Immediate call/response style

Independent continuation

Common method-call behavior

Common event/message behavior

Caller depends on completion

Caller can continue

Mental model:

SYNC:
Call -> Wait -> Response -> Continue

ASYNC:
Send -> Continue
        |
        +---- receiver processes later

41. Create Message

A sequence diagram can also represent creation of a new object.

Example:

ATM
 |
 | create Transaction
 v
Transaction
 |

The Transaction object does not exist before the creation message.

This is useful when a use case dynamically creates objects.

42. Destroy Message

A destroy message represents the termination of an object's lifecycle.

Conceptually:

A --------X B

The object/lifeline ends after destruction.

This is useful when an object has a clearly defined lifecycle within the interaction.

43. Lost Message

A lost message represents a message that does not reach its intended receiver.

Conceptually:

A ---------> X

The destination is not available/known to receive the message.

44. Found Message

A found message represents a message arriving from an unknown or external source.

Conceptually:

? ---------> A

The source of the message is not represented as a normal participating object.

45. Sequence Diagram Conditions

Real applications contain conditions.

Example:

if balance >= amount
    dispense cash
else
    reject transaction

A sequence diagram can represent this using an ALT fragment.

Conceptually:

+-----------------------------+
| alt                         |
|                             |
| [balance sufficient]        |
|     dispenseCash()          |
|                             |
|-----------------------------|
| [insufficient balance]      |
|     reject()                |
+-----------------------------+

46. Option Fragment

An opt fragment represents an optional condition.

Conceptually:

+-----------------------------+
| opt [condition]             |
|     execute operation       |
+-----------------------------+

Think:

opt
=
if without else

47. Loop Fragment

Repeated operations can be represented using a loop fragment.

Example:

for each item
    process(item)

Sequence diagram concept:

+-----------------------------+
| loop [condition]            |
|     process()               |
+-----------------------------+

This is useful for:

Iterating through items

Retrying operations

Polling

Repeated requests

48. ATM Example

A good example for understanding sequence diagrams is an ATM withdrawal.

Objects:

User
ATM
Transaction
Account
CashDispenser

Basic flow:

User
 |
 | enter account / PIN
 v
ATM
 |
 | create transaction
 v
Transaction
 |
 | verify account
 v
Account
 |
 | balance check
 v
Transaction
 |
 | dispense cash
 v
CashDispenser
 |
 | cash
 v
User

49. ATM Happy Flow

The happy path could be:

1. User enters account information.
2. User enters withdrawal amount.
3. ATM receives request.
4. ATM creates Transaction.
5. Transaction verifies account.
6. Account verifies sufficient balance.
7. Transaction succeeds.
8. ATM tells CashDispenser to dispense cash.
9. User receives cash.

The sequence diagram shows the exact order in which these objects communicate.

50. ATM Sequence — Simplified

User        ATM       Transaction       Account       CashDispenser
 |           |             |               |                |
 | withdraw  |             |               |                |
 |---------->|             |               |                |
 |           | create      |               |                |
 |           |------------>|               |                |
 |           |             | verify        |                |
 |           |             |-------------->|                |
 |           |             |<--------------|                |
 |           |             |               |                |
 |           |             | dispense                      |
 |           |--------------------------------------------->|
 |           |                                             |
 |<----------|                                             |

This is a behavioral view of the use case.

51. ALT in ATM

What if the account has insufficient funds?

We can represent:

alt
    [balance sufficient]
        dispenseCash()

    [balance insufficient]
        rejectTransaction()

So the sequence diagram can represent multiple execution paths.

52. Happy Flow

The happy flow is the normal successful scenario.

Example:

PIN correct
+
Balance sufficient
+
ATM operational
+
Cash available
=
Successful withdrawal

During interviews, first explain the happy flow.

Then discuss important alternate/error flows.

53. One Use Case → One Sequence Flow

A sequence diagram is usually designed around a specific use case.

For example:

ATM
 |
 +-- Withdraw Cash
 |
 +-- Check Balance
 |
 +-- Change PIN
 |
 +-- Deposit Cash

Each can have its own interaction sequence.

Do not try to put every possible operation into one giant sequence diagram.

54. How to Create a Class Diagram

Use this process during LLD interviews:

Step 1 — Identify nouns

From the requirements, identify important entities.

Example:

Customer
Restaurant
Order
Payment
Delivery

Step 2 — Convert important nouns into classes

Customer
Restaurant
Order
Payment
Delivery

Step 3 — Identify attributes

Example:

Order
- orderId
- amount
- status

Step 4 — Identify behaviors

Order
+ place()
+ cancel()
+ calculateTotal()

Step 5 — Identify relationships

Ask:

IS-A?
HAS-A?
USES?

Step 6 — Add multiplicity where useful

Example:

Customer 1 -------- * Order

Step 7 — Check whether inheritance is actually needed

Prefer composition when the relationship is a HAS-A.

55. How to Create a Sequence Diagram

Use this process:

Step 1 — Select one use case

Example:

Place Order

Step 2 — Identify participating objects

Customer
OrderService
Order
PaymentService
Restaurant

Step 3 — Identify the first request

Customer -> OrderService

Step 4 — Follow the execution flow

OrderService
     |
     +--> Order
     |
     +--> PaymentService
     |
     +--> Restaurant

Step 5 — Add responses

PaymentService -> OrderService

Step 6 — Add conditions

alt [payment successful]
alt [payment failed]

Step 7 — Add loops/async behavior if required

loop
async

56. Class Diagram Mental Model

Whenever you see a class diagram, ask:

What objects/classes exist?
        |
        v
What data do they own?
        |
        v
What behavior do they expose?
        |
        v
How are they related?

57. Sequence Diagram Mental Model

Whenever you see a sequence diagram, ask:

Who starts the request?
        |
        v
Which object receives it?
        |
        v
Which object does it call next?
        |
        v
What response comes back?
        |
        v
What happens next?

58. Important UML Symbols Cheat Sheet

+------------------------------+
| UML QUICK REFERENCE          |
+------------------------------+

+  -> public
-  -> private
#  -> protected
~  -> package/default

^ / hollow triangle
   -> inheritance

---->
   -> association / navigability

◇
   -> aggregation

◆
   -> composition

| dashed vertical line
   -> lifeline

[====]
   -> activation bar

---->
   -> message

- - ->
   -> return / response

alt
   -> if/else alternatives

opt
   -> optional behavior

loop
   -> repeated behavior

59. Most Important Interview Concepts

Before an LLD interview, be comfortable with:

Class Diagram

Class

Attributes

Methods

Visibility

Abstract class

Concrete class

Association

Inheritance

Aggregation

Composition

Sequence Diagram

Object

Lifeline

Activation bar

Message

Synchronous message

Asynchronous message

Return message

Create message

Destroy message

Lost message

Found message

alt

opt

loop

60. Common Mistakes

Mistake 1 — Using inheritance everywhere

Bad thinking:

Car extends Engine

This is wrong because:

Car IS-NOT-A Engine

It is:

Car HAS-A Engine

Mistake 2 — Confusing aggregation and composition

Ask:

Can the child/part meaningfully exist independently?

If yes, aggregation may make sense.

If its lifecycle is strongly tied to the parent, composition may make sense.

Mistake 3 — Making one giant sequence diagram

A sequence diagram should focus on a particular use case.

Do not combine every application operation into one diagram.

Mistake 4 — Confusing class and object

Class diagram:

Customer

Sequence diagram:

customer1

Class describes the type.

Object represents a runtime instance.

61. Interview Cheat Sheet

UML
 |
 +---- Structural
 |       |
 |       +---- Class Diagram
 |
 +---- Behavioral
         |
         +---- Sequence Diagram

Class Diagram

Class
 |
 +-- Name
 +-- Attributes
 +-- Methods
 +-- Relationships

Relationships

IS-A
 |
 +-- Inheritance

HAS-A
 |
 +-- Association
 +-- Aggregation
 +-- Composition

Composition strength

Association
     ↓
Aggregation
     ↓
Composition

From weaker to stronger ownership.

Sequence

Objects
   |
Lifelines
   |
Messages
   |
Execution order
   |
Responses / conditions / loops

62. Final Takeaways

The most important lessons are:

UML is a visual language for communicating software design.

Class diagrams describe static structure.

Sequence diagrams describe dynamic interactions.

A class diagram shows classes, attributes, methods, and relationships.

Inheritance represents an IS-A relationship.

Association, aggregation, and composition represent HAS-A style relationships.

Aggregation uses a hollow diamond.

Composition uses a filled diamond.

Composition represents stronger ownership/lifecycle dependency.

Sequence diagrams show interactions in time order.

Lifelines represent object existence.

Activation bars represent active execution.

Synchronous calls wait for a response.

Asynchronous calls allow the sender to continue.

alt represents alternatives.

opt represents optional behavior.

loop represents repeated behavior.

For LLD interviews, Class Diagram + Sequence Diagram are especially important.

63. One-Line Revision

Class Diagram tells us WHAT the system contains; Sequence Diagram tells us HOW those objects interact.

64. Practice Problems

After studying this topic, practice drawing class + sequence diagrams for:

Beginner

Parking Lot

Library Management System

ATM

Tic-Tac-Toe

Intermediate

Food Delivery System

Movie Ticket Booking

Ride Booking

Inventory Management

Advanced

Elevator System

Splitwise

Online Shopping

Document Editor

For every problem, first create:

1. Class Diagram
2. One Sequence Diagram for the main use case

Then move to code.

65. LLD Learning Flow

A good learning order is:

OOP
  |
  v
SOLID
  |
  v
UML
  |
  +---- Class Diagram
  |
  +---- Sequence Diagram
  |
  v
Design Patterns
  |
  v
LLD Problems
  |
  v
Complete Projects

The UML knowledge from this lesson becomes the bridge between OOP/SOLID theory and actual LLD design problems.
