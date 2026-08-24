package oop.interfaces;

import oop.classs.Car;

public class HybridCar extends Car implements  Chargeable {
    private int fuelLevel;
    public HybridCar(String brand, String color, int speed, int fuelLevel) {
        super(brand, color, speed);
        if (fuelLevel < 0) throw new IllegalArgumentException("Fuel level cannot be negative");
        this.fuelLevel = fuelLevel;
    }
    @Override
    public void DisplayInfo(){
        super.DisplayInfo();
        System.out.println("fuelLevel:" + fuelLevel);
    }

    @Override
    public void charge() {
        System.out.println("charging hybrid! ");
    }
}
