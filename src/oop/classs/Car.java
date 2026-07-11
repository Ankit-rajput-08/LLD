package oop.classs;


public class Car {

    private String brand;
    private String color;
    private String speed;



    public void DisplayInfo(){
        System.out.println("brand: " + brand );
        System.out.println("color: " + color);
        System.out.println("speed: " + speed);
    }

    public Car(String brand, String color, String speed) {
        this.brand = brand;
        this.color = color;
        this.speed = speed;
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

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
