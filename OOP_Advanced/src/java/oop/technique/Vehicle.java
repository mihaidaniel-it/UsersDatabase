package java.oop.technique;

import java.oop.explotation.Acceleration;
import java.oop.explotation.Breakable;
import java.oop.explotation.Cargo;
import java.oop.explotation.Refuelled;

public abstract class Vehicle implements Acceleration, Breakable, Cargo, Refuelled {
//    Поля
    private String model;
    private double vehicleCondition = Math.random() * 100;
    private int vehicleWeight;
    private int averageSpeed;
    private int tankVolume;
    private int x = 0;

//    Конструктор
    public Vehicle(String model, int vehicleWeight, int averageSpeed, int tankVolume) {
        this.model = model;
        this.vehicleWeight = vehicleWeight;
        this.averageSpeed = averageSpeed;
        this.tankVolume = tankVolume;
    }

//    Методы
    public void move() {
        this.x += averageSpeed;

        if (!isBroken()) {
            acceleration();
        }
        if (!isCargo()) {
           acceleration();
        }
        if (!refuel()) {
            acceleration();
        }
    }

    @Override
    public void acceleration() {
        averageSpeed += 5;
    }

    @Override
    public boolean isBroken() {
        if (vehicleCondition < 45) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isCargo() {
        if (vehicleWeight < 2500) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean refuel() {
        if (tankVolume > 45) {
            return true;
        } else {
            return false;
        }
    }

//    Геттеры
    public int getX() {
        return x;
    }

    public int getAverageSpeed() {
        return averageSpeed;
    }

    public double getVehicleCondition() {
        return vehicleCondition;
    }

    public int getTankVolume() {
        return tankVolume;
    }

    public int getVehicleWeight() {
        return vehicleWeight;
    }
}
