package java.oop.technique;

import java.oop.explotation.Acceleration;
import java.oop.explotation.Breakable;

public class Bicycle extends Vehicle implements Breakable, Acceleration {
    //    Конструктор
    public Bicycle(String model, int vehicleWeight, int averageSpeed, int tankVolume) {
        super(model, vehicleWeight, averageSpeed, tankVolume);
    }

    //    Методы
    @Override
    public void move() {
        int averageSpeed = getAverageSpeed();
        int x = getX();

        x += averageSpeed;

        if (!isBroken()) {
            acceleration();
        }
    }

    @Override
    public void acceleration() {
        int x = getX();
        int averageSpeed = getAverageSpeed();
        x += 1;
        averageSpeed += x;
    }
}
