package java.oop.technique;

import java.oop.explotation.Acceleration;
import java.oop.explotation.Breakable;
import java.oop.explotation.Cargo;
import java.oop.explotation.Refuelled;

public class Car extends Vehicle implements Refuelled, Breakable, Cargo, Acceleration {
//    Конструктор
    public Car(String model, double vehicleWeight, int averageSpeed, int tankVolume) {
        super(model, vehicleWeight, averageSpeed, tankVolume);
    }
}
