package java.oop.technique;

import java.oop.explotation.Acceleration;
import java.oop.explotation.Breakable;
import java.oop.explotation.Cargo;
import java.oop.explotation.Refuelled;

public abstract class Vehicle implements Acceleration, Breakable, Cargo, Refuelled {
//    Поля
    private String model;
    private double vehicleCondition = Math.random() * 100;
    private double vehicleWeight;
    private int averageSpeed;
    private int tankVolume;
    private int x = 0;

//    Конструктор
    public Vehicle(String model, double vehicleWeight, int averageSpeed, int tankVolume) {
        this.model = model;
        this.vehicleWeight = vehicleWeight;
        this.averageSpeed = averageSpeed;
        this.tankVolume = tankVolume;
    }

//    Методы
    public void move() {
        this.x += averageSpeed;
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
            System.out.println("Ваша машина сломалась. Гонка завершена!");
            return false;
        }
    }

    @Override
    public boolean isCargo() {
        if (vehicleWeight < 2500) {
            averageSpeed += 5;
            return false;
        } else {
            averageSpeed -= 5;
            return true;
        }
    }

    public void refuel() {
        if (tankVolume > 45) {
            acceleration();
        }
    }
}
