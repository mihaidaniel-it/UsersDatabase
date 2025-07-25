package java_oop;

import java_oop.services.Competition;
import java_oop.technique.Bike;
import java_oop.technique.Car;
import java_oop.technique.Motorcycle;
import java_oop.technique.Vehicle;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("BMW", 100, 40, 2100);
        Motorcycle motorcycle = new Motorcycle("Yamaha", 200, 20);
        Bike bike = new Bike("BMX", 10, false, true);

        Competition competition = new Competition(500);

        Vehicle[] vehicles = {car, motorcycle, bike};

        Vehicle vehicle = competition.race(vehicles);
        System.out.println("В гонке победила модель т/с: " + vehicle.getModel());
    }
}