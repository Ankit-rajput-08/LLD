package oop.classs;

/*
Q1. What is the difference between a constructor and a method?
ConstructorMethodPurposeInitialize object fields at creationDefine object behaviourReturn typeNoneHas a return typeInvocationOnce, automatically at newMultiple times, explicitlyNameSame as class nameAny valid name

Q2. What is the default constructor? What happens when you define your own?
Java automatically provides a default no-arg constructor if you don't write any constructor. The moment you define your own constructor, Java removes the default one entirely. So new Car() will throw a compile-time error unless you explicitly write a no-arg constructor yourself.

Q3. Can a constructor have a return type?
No. If you add a return type, Java treats it as a regular method, not a constructor. The constructor's return is implicitly the object itself — handled by the JVM via new.

Q4. What is constructor overloading?
Defining multiple constructors in the same class with different parameter lists (different number, type, or order of parameters). This is compile-time polymorphism — the compiler decides which constructor to invoke based on the arguments passed at new.

Q5. What are the uses of the this keyword?

this.field → refers to the current object's field, resolves ambiguity with parameter names
this() → calls another constructor of the same class (constructor chaining)
this as argument → passes the current object reference to another method

Q6. Can a constructor be private? Why would you do that?
Yes. Used in Singleton pattern to prevent external instantiation — object creation is controlled entirely from within the class.
Q7. . What happens in memory when you create an object? (Car c = new Car();)
Three things happen: (1) JVM allocates memory on the heap for the object's fields, (2) the constructor runs to initialize it, (3) the reference c on the stack is set to point to that heap address.

Q8. static doesn't make sense — constructors work on the instance being created, not the class.
final/abstract relate to overriding, but constructors aren't inherited or overridden at all, so these modifiers are meaningless on them.


 ##final field — must be initialized exactly once, either at declaration or in the constructor. Never again after that.
 */

import java.util.concurrent.atomic.AtomicInteger;

public class Car {
    private static AtomicInteger totalCars;
    static {
        totalCars = new AtomicInteger(0);
    }

    private String brand;
    private String color;
    private int speed;



    public void DisplayInfo(){
        System.out.println("brand: " + brand );
        System.out.println("color: " + color);
        System.out.println("speed: " + speed);
    }

    public Car(String brand, String color, int speed) {

        this.brand = brand;
        this.color = color;
        if (speed < 0){
            throw new IllegalArgumentException("Speed cannot be negative");

        }
        this.speed = speed;
        totalCars.incrementAndGet();
    }
    public static int getTotalCars(){
        return totalCars.get();
    }

    // ENCAPSULATION
    //making all field private and use getter and setters

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
