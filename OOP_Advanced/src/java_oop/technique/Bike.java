package java_oop.technique;

import java_oop.explotation.Viability;

public class Bike extends Vehicle implements Viability {
    //    Поля
    private boolean isRain;
    private boolean isGoodRoad;

    //    Конструктор
    public Bike(String model, int speed, boolean isRain, boolean isGoodRoad) {
        super(model, speed);
        this.isRain = isRain;
        this.isGoodRoad = isGoodRoad;
    }

    //    Методы
    @Override
    public int move(int raceDistance) {
        int speed = getSpeed();

        speed = transportViability();

        if (speed <= 0) {
            System.out.println("Машина сломалась, гонка проиграна!");
        }

        return speed;
    }

    @Override
    public int transportViability() {
        int speed = getSpeed();

        if (isRain && !isGoodRoad) {
            speed = 0;
            return speed;
        } else if (!isRain && isGoodRoad) {
            speed += 3;
            return speed;
        } else if (isRain || !isGoodRoad) {
            speed -= 3;
            return speed;
        }

        return speed;
    }
}