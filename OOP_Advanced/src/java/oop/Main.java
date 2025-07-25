package java.oop;

import java.oop.services.Competition;
import java.oop.technique.Car;
import java.oop.technique.Vehicle;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car("BMW", 1500, 60, 40);
        Vehicle bicycle = new Car("Pobed", 2, 2, 0);
        Vehicle motorbike = new Car("Yamaha", 175, 80, 15);

        Competition competition = new Competition();
        competition.setParticipants(car, bicycle, motorbike);
        competition.race();
    }
}