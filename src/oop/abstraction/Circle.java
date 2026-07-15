package oop.abstraction;

public class Circle extends Shape {


    @Override
    double area() {
        double r = 5;
        return  3.14 * r * r;
    }
}
