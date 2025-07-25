package java.oop.services;

import java.oop.technique.Bicycle;
import java.oop.technique.Car;
import java.oop.technique.Motorbike;
import java.oop.technique.Vehicle;

public class Competition {
    private int raceDistance = 100;
    Vehicle[] vehicles = new Vehicle[3];

//    Методы
    public void setParticipants(Vehicle car, Vehicle bicycle, Vehicle motorbike) {
        vehicles[0] = car;
        vehicles[1] = bicycle;
        vehicles[2] = motorbike;
    }

    public void race() {
        int carX = vehicles[0].getX();
        int bicycleX = vehicles[1].getX();
        int motorbikeX = vehicles[2].getX();

        while (carX == raceDistance || bicycleX == raceDistance || motorbikeX == raceDistance) {
            vehicles[0].move();
            vehicles[1].move();
            vehicles[2].move();

            if (carX == raceDistance) {
                System.out.println("Победила машина!");

            } else if (bicycleX == raceDistance) {
                System.out.println("Победил велосипед!");

            } else if (motorbikeX == raceDistance) {
                System.out.println("Победил мотоцикл!");

            }
        }


    }
}
