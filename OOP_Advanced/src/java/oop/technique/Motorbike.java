package java.oop.technique;

import java.oop.explotation.Acceleration;
import java.oop.explotation.Breakable;
import java.oop.explotation.Refuelled;

public class Motorbike extends Vehicle implements Breakable, Refuelled, Acceleration {
    //    Конструктор
    public Motorbike(String model, int vehicleWeight, int averageSpeed, int tankVolume) {
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
        if (refuel()) {
            acceleration();
        }
    }

    @Override
    public void acceleration() {
        int averageSpeed = getAverageSpeed();
        averageSpeed += 5;
    }

    @Override
    public boolean refuel() {
        int tankVolume = getTankVolume();

        if (tankVolume < 20) {
            return true;
        } else {
            return false;
        }
    }
}
