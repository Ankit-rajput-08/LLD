package oop.interfaces;

/*

Ans 2 — One correction (Post Java 8)
Interfaces are no longer full abstraction strictly. Java 8 added default and static methods with bodies in interfaces. But for interviews — abstract class = partial, interface = contract. That framing holds.

Ans 3 — You cannot instantiate an abstract class
What you likely did was this — anonymous class syntax:
javaShape s = new Shape() {        // ❌ looks like instantiation
    public double area() {      // but you're creating an
        return 0;               // anonymous subclass inline
    }
};
This is NOT instantiating Shape. Java is creating an unnamed subclass of Shape on the fly and instantiating that. Try this — it will fail:
javaShape s = new Shape(); // ❌ compile error — cannot instantiate abstract class

Ans 4 — Interface has no constructor because:

Constructor's job is to initialize object state (fields)
Interfaces cannot have instance fields
You can never do new Chargeable() — nothing to initialize
Therefore constructor makes no sense for an interface


Ans 5 — Diamond problem, assume
class D extends B and C
B and C both extend class A.
class A has method print().

now we call D.print(), which method D will call, both C and B have same method how will class decide?

In c++ it is solved by method reference or scope resolation operator(::) but java completely discard such scenario by not allowing multiple inheritance.

Ans 6 — Your observation is right, here's the clean reasoning:
Use Abstract ClassUse InterfaceClasses share common fieldsNo shared state neededClasses share some common behaviourEvery method needs its own implementationStrong IS-A relationshipCAN-DO relationshipHybridCar IS-A CarHybridCar CAN charge()
One liner for interviews:

Abstract class for shared identity. Interface for shared capability.

Car is an identity — all cars share brand, color, speed. Chargeable is a capability — unrelated things (car, bike, phone) can all be chargeable.

Ans 7 — Default and Static methods in interfaces (Java 8+)
Problem before Java 8:
If you add a new method to an interface, every class implementing it breaks — must implement the new method.
default method — solves backward compatibility:
javapublic interface Chargeable {
    void charge();

    default void checkBattery() {          // has a body
        System.out.println("Checking battery...");
    }
}
Implementing classes get checkBattery() for free. Can override if needed. Existing code doesn't break.
static method — utility on the interface itself:
javapublic interface Chargeable {
    static int maxBatteryLevel() {   // belongs to interface, not object
        return 100;
    }
}

// Called as:
Chargeable.maxBatteryLevel(); // ✅
Cannot be overridden. Just a helper utility tied to the interface.
 */
public interface Chargeable {

     void charge();
}
