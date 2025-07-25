package java_oop.services;

import java_oop.technique.Vehicle;

public class Competition {
//    todo: должны поделить raceDistance / x каждого т/с = кол-во итераций в цикле
//    todo: у какой машины будет первый х == raceDistance - победил
//    Поля
    private int raceDistance;
    private int[] racersSpeed = new int[5];

//    Конструктор
    public Competition(int raceDistance) {
        this.raceDistance = raceDistance;
    }

//    Методы
    public Vehicle race(Vehicle[] vehicles) {
        for (int i = 0; i < vehicles.length; i++) {
            racersSpeed[i] = vehicles[i].move(raceDistance);
        }

        int maxSpeedOfRacer = racersSpeed[0];
        int numberOfFastetRacer = 0;
        for (int i = 0; i < racersSpeed.length; i++) {
            if (maxSpeedOfRacer < racersSpeed[i]) {
                maxSpeedOfRacer = racersSpeed[i];
                numberOfFastetRacer = i;
            }
        }

        return vehicles[numberOfFastetRacer];
    }
}