package hu.codecool;

import java.util.Random;

public class Truck extends Vehicle {

    static int speed = 100;
    int breakdownTurnsLeft = 0;

    public Truck() {
        type = "Truck";
    }

    public static String createName() {

        Random random = new Random();
        int name = random.nextInt(1001);
        return String.valueOf(name);
    }

    @Override
    public void moveForAnHour(boolean isRaining) {

        Random random = new Random();

        if (breakdownTurnsLeft == 0) {
            int breakDownChance = random.nextInt(101);
            if (breakDownChance <= 5) {
                breakdownTurnsLeft = 2;
            } else {
                distanceTraveled += speed;
            }
        } else {
            breakdownTurnsLeft--;
        }
    }
}
