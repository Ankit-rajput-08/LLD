package oop.classs;

import oop.inheritance.ElectricCar;

public class Main {
    public static void main(String[] args){

        //without constructor

//        Car coup = new Car();
//        coup.brand = "BMW";
//        coup.color = "Black";
//        coup.speed = "180";
//        System.out.println("for coup");
//        coup.DisplayInfo();

        // after using constructor
        Car sedan = new Car("mercedes","black",160);
        System.out.println("Displaing info for :" + sedan);
        sedan.DisplayInfo();
        Car mc = new Car("maruti","white",100);
        ElectricCar mcc = new ElectricCar("maruti","White",100,67);

        System.out.println("total cars: " + Car.getTotalCars());
    }




}
