package hu.codecool;

import java.util.Random;

public class Motorcycle extends Vehicle {

    static int defaultSpeed = 100;
    static int nameNumber = 1;

    public Motorcycle() {
        type = "Motorcycle";
    }

    @Override
    public void moveForAnHour(boolean isRaining) {
        Random random = new Random();
        int speed = isRaining ? defaultSpeed - random.nextInt(46) + 5 : defaultSpeed;
        distanceTraveled += speed;
    }

    public static String createName() {

        String name = "Motorcycle " + nameNumber++;
        return name;
    }
}

/*
Motorcycle // speed is 100km/h. If rains, travels with 5-50km/h slower (randomly).
static nameNumber // The number of the instance created. Used for its name.
        name // Are called "Motorcycle 1", "Motorcycle 2", "Motorcycle 3",... Unique.
        distanceTraveled
        moveForAnHour()
*/
