package java_oop.technique;

import java_oop.explotation.Breakable;
import java_oop.explotation.Cargo;
import java_oop.explotation.Refuelled;

public class Car extends Vehicle implements Refuelled, Breakable, Cargo {
    //    Поля
    private int tankVolume;
    private double breakdownProbability = Math.random();
    private int carWeight;

    //    Конструктор
    public Car(String model, int speed, int tankVolume, int carWeight) {
        super(model, speed);
        this.tankVolume = tankVolume;
        this.carWeight = carWeight;
    }

    //    Методы
    @Override
    public int move(int raceDistance) {
        int speed = getSpeed();

        int distanceOnFullTank = (tankVolume / 10) * 100;
        int refuelCount = Math.round(raceDistance / distanceOnFullTank);
        for (int i = 0; i < refuelCount; i++) {
            int newSpeed = refuel();
            speed = newSpeed;
        }

        if (isBroken()) {
            speed /= 2;
        }

        if (isLoaded()) {
            speed -= 5;
        }

        if (speed <= 0) {
            System.out.println("Машина сломалась, гонка проиграна!");
        }

        return speed;
    }

    @Override
    public int refuel() {
        int speed = getSpeed();
        speed -= 5;

        return speed;
    }

    @Override
    public boolean isBroken() {
        if (breakdownProbability > 0.75) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isLoaded() {
        if (carWeight > 1400) {
            return true;
        } else {
            return false;
        }
    }
}