package oop.inheritance;

import oop.classs.Car;

/*
Ans1:
Inheritance -> A concept  of OOP in which Child classes can inherit fields and method of a parent class.
We need Inheritance to reduce the redundancy of code logic, there are common methods and fields in real world for same type of classes we do not want to write same code for each one directly they can extend a parent class and can use or modify code accordingly.

Ans2:
super() vs super.method
super() is used to call the constructor of parent class and super.method is used to call method of parent class inside child's logic

Ans3:
Private fields are uninheritable, no children can access them directly.

Ans4:
Method overriding:
it is a runtime polymorphism used to write custom logic per children's need by using the same method name.

Ans5:
Method overriding: is runtime polymorphism, uses same name, same return type no visible difference but just different logic.
Method overloading : is compile time polymorphism uses same name, but the parameter count or return type must be different.

Ans6:
@Override an annotation signifiezes that following method is overridden by children class, no it is not mandatory but a good practice.

Ans7:
overriding a method is applicable on instance methods, static methods belong to the class not instance, so might be they cannot but not clear knowledge of it

Q8.  What are the types of inheritance in Java? Does Java support multiple inheritance?
Types: single, multilevel, hierarchical. Java does not support multiple inheritance with classes (a class can't extend two classes) to avoid the Diamond Problem — ambiguity over which parent's method to inherit if both have the same method. It's allowed with interfaces instead.

 */

public class ElectricCar extends Car {
    private int batteryLevel;
    public ElectricCar(String brand, String color, int speed,int batteryLevel) {
        super(brand, color, speed);
        if (batteryLevel < 0) {
        throw new IllegalArgumentException("level cannot be negative");        }
        this.batteryLevel = batteryLevel;
    }

    public void charge(){
        System.out.println("Car is Charging! ");
    }
    @Override
    public void DisplayInfo(){
        super.DisplayInfo();
        System.out.println("battery level: " + batteryLevel);
    }

}
