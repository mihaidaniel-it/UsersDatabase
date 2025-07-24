package java.oop.technique;

import java.oop.explotation.Acceleration;
import java.oop.explotation.Breakable;

public class Bicycle extends Vehicle implements Breakable, Acceleration {
    //    Конструктор
    public Bicycle(String model, double vehicleWeight, int averageSpeed, int tankVolume) {
        super(model, vehicleWeight, averageSpeed, tankVolume);
    }

    //    Методы
    @Override
    public void acceleration() {
        int x = getX();
        int averageSpeed = getAverageSpeed();
        x += 2;
        averageSpeed += x;
    }

    @Override
    public boolean isBroken() {
        double vehicleCondition = getVehicleCondition();

        if (vehicleCondition < 45) {
            return true;
        } else {
            System.out.println("Велик сломан. Гонка завершена!");
            return false;
        }
    }
}
