package oop.encapsulation;

/*

Encapsulation — Interview Q&A
Q1. What is Encapsulation and why do we need it?
Encapsulation means making object fields private to prevent direct external access. It is needed to prevent objects from reaching an invalid or inconsistent state — like setting speed as negative or name as null — by adding validation logic in controlled getters and setters.

Q2. What is the difference between private, public, and protected access modifiers?
ModifierSame ClassSame PackageSubclassEverywhereprivate✅❌❌❌protected✅✅✅❌public✅✅✅✅(default)✅✅❌❌
Default (no modifier) = same package only.

Q3. Can you have a class with only getters and no setters?
Yes. Such classes are called Immutable classes — read-only objects whose state cannot be changed after creation. String in Java is the most famous example.

Q4. Is encapsulation only about private fields and getters/setters?
No. Encapsulation is about preventing invalid or direct access to object state and adding validation logic that controls how fields are accessed or modified.

Q5. What is the difference between Encapsulation and Abstraction?

Encapsulation → hides the data (fields) and controls access through methods. Protects object integrity.
Abstraction → hides the implementation details and exposes only what is necessary. Like a sort() method — the caller knows it sorts, not how it sorts internally.

Q6. How does encapsulation help in real-world backend systems (Spring Boot context)?

Answer: This is a great one to bring up in interviews given your Spring Boot/JPA background.
Entity classes: JPA @Entity classes keep fields private with getters/setters, so the persistence layer and business logic don't directly manipulate raw DB columns without going through validation.
DTOs: Encapsulation ensures a UserDTO sent over a REST API doesn't leak sensitive internal fields (like password) — you simply don't expose a getter for it.
Service layer: Encapsulating business logic in service classes (private helper methods) hides internal steps from the controller layer, so controllers just call service.processPayment() without knowing the internal steps.
 */
public class Encapsulation {

    private String name;
    private int age;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age > 0) this.age = age;
    }
}
