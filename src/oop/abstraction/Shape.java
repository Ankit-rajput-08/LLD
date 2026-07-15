package oop.abstraction;

public abstract class Shape {

    abstract double area();

    public void displayArea(){
        System.out.println(area());
    }
}
