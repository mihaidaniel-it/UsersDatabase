package java.oop.technique;

import java.oop.explotation.Acceleration;
import java.oop.explotation.Breakable;
import java.oop.explotation.Cargo;
import java.oop.explotation.Refuelled;

public class Car extends Vehicle implements Refuelled, Breakable, Cargo, Acceleration {
    //    Конструктор
    public Car(String model, int vehicleWeight, int averageSpeed, int tankVolume) {
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
        if (!isCargo()) {
            acceleration();
        }
        if (refuel()) {
            acceleration();
        }
    }

    @Override
    public void acceleration() {
        int averageSpeed = getAverageSpeed();
        averageSpeed += 3;
    }

    @Override
    public boolean isCargo() {
        int vehicleWeight = getVehicleWeight();

        if (vehicleWeight < 2000) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean refuel() {
        int tankVolume = getTankVolume();

        if (tankVolume < 45) {
            return true;
        } else {
            return false;
        }
    }
}
