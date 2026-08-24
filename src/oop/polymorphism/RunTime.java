package oop.polymorphism;

import oop.classs.Car;
import oop.inheritance.ElectricCar;

/*
instanceof checks the actual object type before casting — prevents ClassCastException.

Java Polymorphism Interview Questions & Answers
Q1. What is Polymorphism? What are its two types?

Answer:

Polymorphism means "one object, many forms." It allows the same method or interface to perform different behaviors depending on the object.

Types of Polymorphism:

Compile-Time Polymorphism (Static Polymorphism)
Achieved through Method Overloading.
The compiler decides which method to execute.
Runtime Polymorphism (Dynamic Polymorphism)
Achieved through Method Overriding.
The JVM decides which method to execute at runtime based on the actual object.
Q2. What is the difference between Compile-Time and Runtime Polymorphism?

Answer:

Compile-Time Polymorphism	Runtime Polymorphism
Achieved using Method Overloading	Achieved using Method Overriding
Decision made by Compiler	Decision made by JVM
Static Binding	Dynamic Binding
Inheritance is not required	Inheritance is required
Faster because method is resolved during compilation	Slightly slower due to runtime method resolution
Q3. What is Dynamic Method Dispatch?

Answer:

Dynamic Method Dispatch is the mechanism through which the JVM decides which overridden method to execute at runtime based on the actual object, not the reference type.

It is the foundation of runtime polymorphism.

Q4. If a parent reference holds a child object, which methods can you call?

Answer:

You can call only the methods that are declared in the parent class (or inherited by it).

If those methods are overridden in the child class, the child's implementation is executed.

Methods that exist only in the child class cannot be accessed using the parent reference unless the object is downcast.

Q5. What is the difference between instanceof and casting? When would you use them?

Answer:

instanceof
Used to check whether an object belongs to a particular class or interface.
Returns true or false.
Helps prevent invalid type conversions.
Casting
Used to convert a reference from one type to another.
Upcasting is safe and automatic.
Downcasting may throw ClassCastException if the object is not of the target type.

When to use them?

Use instanceof before downcasting to ensure the object is of the expected type and avoid runtime exceptions.
Q6. Can polymorphism work without inheritance?

Answer:

Compile-Time Polymorphism: Yes. Method overloading does not require inheritance.
Runtime Polymorphism: No. Method overriding requires inheritance or interface implementation.
Additional Interview Questions
Q7. Why is Method Overloading called Compile-Time Polymorphism?

Answer:

Because the compiler determines which overloaded method to call during compilation based on the method signature.

Q8. Why is Method Overriding called Runtime Polymorphism?

Answer:

Because the JVM decides which overridden method to execute during runtime based on the actual object.

Q9. What is Method Overloading?

Answer:

Method Overloading is the ability to define multiple methods with the same name but different parameter lists within the same class. It provides compile-time polymorphism.

Q10. What is Method Overriding?

Answer:

Method Overriding is when a child class provides its own implementation of a method already defined in the parent class. It provides runtime polymorphism.

Q11. What is the difference between Overloading and Overriding?

Answer:

Method Overloading	Method Overriding
Same class	Parent and Child classes
Different parameters	Same method signature
Compile-time	Runtime
Inheritance not required	Inheritance required
Static Binding	Dynamic Binding
Q12. What is Upcasting?

Answer:

Upcasting is the process of treating a child object as an instance of its parent class.

It is automatic, safe, and enables runtime polymorphism.

Q13. What is Downcasting?

Answer:

Downcasting is converting a parent reference back to a child reference.

It requires explicit casting and should be performed only when the object is actually of the child type.
 */
public class RunTime {
    public  void runtime() {

        Car[] cars = {new Car("bmw", "xuv", 123),
                new ElectricCar("zyu", " mersedice", 140, 90),
                new Car("brnd", "8930", 90),
                new ElectricCar("hsjf", "skkf", 90, 77)};
        for (Car car : cars){
            car.DisplayInfo();
        }

        Car hybridCar = new ElectricCar("Tesla", "White", 200, 90);

        if (hybridCar instanceof ElectricCar electricCar) {
            electricCar.charge();
        }
    }
}
