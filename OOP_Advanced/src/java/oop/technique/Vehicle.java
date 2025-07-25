package java.oop.technique;

import java.oop.explotation.*;

public abstract class Vehicle implements
        Acceleration,
        Breakable,
        Cargo,
        Refuelled,
        Viability {
// Поля
    private String model;
    private int speed;
    private int x = 0;

//    Конструктор
    public Vehicle(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

//    Методы
    public void move() {
        x = speed;
    }

//    Абстрактные методы
    public abstract void refuel();
    public abstract boolean isBroken();
    public abstract void acceleration();
    public abstract boolean isLoaded();
    public abstract void transportViability();
}
