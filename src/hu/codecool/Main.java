package hu.codecool;

import java.util.Random;

public class Main {
static Random random = new Random();
    public static void main(String[] args) {
        createVehicles();
        // simulateRace();
        // printRaceResults();
    }

    private static boolean isRaining() {
        int rain = random.nextInt(100) + 1;
        if (rain <= 30) {
            return true;
        }
            return false;
    }

    private static void createVehicles() {

    }
 }