package java_oop.technique;

import java_oop.explotation.Acceleration;
import java_oop.explotation.Breakable;
import java_oop.explotation.Refuelled;

public class Motorcycle extends Vehicle implements Refuelled, Breakable, Acceleration {
//    Поля
    private int tankVolume;
    private double  breakdownProbability = Math.random();

    //    Конструктор
    public Motorcycle(String model, int speed, int tankVolume) {
        super(model, speed);
        this.tankVolume = tankVolume;
    }

    //    Методы
    @Override
    public int move(int raceDistance) {
        int speed = getSpeed();

        int distanceOnFullTank = (tankVolume / 5) * 100;
        int refuelCount = Math.round(raceDistance / distanceOnFullTank);
        for (int i = 0; i < refuelCount; i++) {
            int newSpeed = refuel();
            speed = newSpeed;
        }

        if (isBroken()) {
            speed /= 2;
        }

        if (acceleration()) {
            speed += 10;
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
    public boolean acceleration() {
        int initialSpeed = getSpeed();
        int speedAfterRefuel = refuel();
        boolean isSameSpeed = initialSpeed == speedAfterRefuel ? true : false;

        if (isBroken() && isSameSpeed) {
            return true;
        } else {
            return false;
        }
    }
}