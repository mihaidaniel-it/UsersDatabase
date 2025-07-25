package java_oop.technique;

public abstract class Vehicle {
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
    public abstract int move(int raceDistance);

//    Геттеры
    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }
}
