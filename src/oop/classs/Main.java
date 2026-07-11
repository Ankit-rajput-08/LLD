package oop.classs;

public class Main {
    public static void main(String[] args){

        //without constructor

//        Car coup = new Car();
//        coup.brand = "BMW";
//        coup.color = "Black";
//        coup.speed = "180";
//        System.out.println("for coup");
//        coup.DisplayInfo();

        // after using constructer
        Car sedan = new Car("mercedes","black","160");
        System.out.println("Displaing info for :" + sedan);
        sedan.DisplayInfo();
    }

    Car car1 = new Car("bmw","green","320");

}
