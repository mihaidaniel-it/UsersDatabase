package java.oop.technique;

import java.oop.explotation.Acceleration;
import java.oop.explotation.Breakable;
import java.oop.explotation.Refuelled;

public class Motorbike extends Vehicle implements Breakable, Refuelled, Acceleration {
    //    Конструктор
    public Motorbike(String model, double vehicleWeight, int averageSpeed, int tankVolume) {
        super(model, vehicleWeight, averageSpeed, tankVolume);
    }

    //    Методы
    @Override
    public void acceleration() {
        int x = getX();
        int averageSpeed = getAverageSpeed();
        x += 10;
        averageSpeed += x;
    }

    @Override
    public void refuel() {
        int tankVolume = getTankVolume();

        if (tankVolume > 12) {
            acceleration();
        }
    }
}
