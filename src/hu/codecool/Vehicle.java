package hu.codecool;

import java.util.Random;

public class Vehicle {

    public String name;
    int distanceTraveled = 0;
    String type;

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void moveForAnHour(boolean isRaining) {
        // distanceTraveled += speed;
    }

    public String getType() {
        return type;
    }
}