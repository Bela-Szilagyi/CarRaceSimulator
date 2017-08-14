package hu.codecool;

import java.util.*;

public class Car extends Vehicle {

    static int speedLimit;
    int normalSpeed;

    public Car() {
        type = "Car";
    }

    public static void setSpeedLimit(int raceSpeedLimit) {
        speedLimit = raceSpeedLimit;
    }

    public void setNormalSpeed() {
        Random random = new Random();
        normalSpeed = random.nextInt(31) + 80;
    }

    public static String[] createNames() {

        String[] carNames = new String[10];

        Random random = new Random();

        List<String> firstNames = new ArrayList(Arrays.asList
            ("Vigor",
            "Ethereal",
            "Thriller",
            "Legacy",
            "Mythic",
            "Vagabond",
            "Parallel",
            "Celestial",
            "Renegade",
            "Prodigy"));

        List<String> lastNames = new ArrayList(Arrays.asList
            ("Ferocity",
            "Dusk",
            "Essence",
            "Motion",
            "Mammoth",
            "Stardust",
            "Symbol",
            "Purity",
            "Icon",
            "Thunder"));

        for (int i = 0; i < 10; i++) {
            int pickedIndex = random.nextInt(firstNames.size());
            String pickedFirstName = firstNames.get(pickedIndex);
            firstNames.remove(pickedIndex);
            pickedIndex = random.nextInt(lastNames.size());
            String pickedLastName = lastNames.get(pickedIndex);
            lastNames.remove(pickedIndex);
            carNames[i] =pickedFirstName + " " + pickedLastName;
        }
        return carNames;
    }

    @Override
    public void moveForAnHour(boolean isRaining) {
        Random random = new Random();
        int speed;
        int speedChance = random.nextInt(101);
        if (speedChance <= 30) {
            speed = 70;
        } else {
            speed = normalSpeed;
        }
        if (speed > speedLimit) {
            speed = speedLimit;
        }
        distanceTraveled += speed;
    }

    /*
    public String getName() {
        return name;
    }
    */
}
