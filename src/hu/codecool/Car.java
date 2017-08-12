package hu.codecool;

import java.util.*;

public class Car {

    static int speedLimit;
    int normalSpeed;
    public String name;
    int distanceTraveled = 0;

    // ArrayList<String> names =new ArrayList<String>();

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

    public void moveForAnHour() {
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

/* // Since cars are so fast there is a 30% chance that they can go only with 70km/h speed.
 static setSpeedLimit(int limit) // Call this from the Main class!
 normalSpeed // the normal speed of the car.
    Set to a random number in the constructor between 80-110km/h.
 name // Make a list from the words here:
    http://www.fantasynamegenerators.com/car-names.php and pick 2 randomly for each instance.
 distanceTraveled // holds the current distance traveled.
 moveForAnHour() // The vehicle travels for an hour.
    It increases the distance traveled. Call this from the main class only!
 */

