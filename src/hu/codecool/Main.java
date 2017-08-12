package hu.codecool;

import java.util.*;

// import static hu.codecool.Logic.getCarNames;

public class Main {

    static Random random = new Random();


    public static void main(String[] args) {

        Car.setSpeedLimit(110);
        Car[] vehicles = createVehicles();
        vehicles = simulateRace(vehicles);
        printRaceResults(vehicles);

        /*
        Map<String, Integer> vehicleStates = new HashMap<String, Integer>();
        vehicleStates.put("car1", 12);
        vehicleStates.put("car2", 6);
        vehicleStates.put("car3", 8);
        System.out.println(vehicleStates);
        Comparator<String> comparator = new Logic.ValueComparator(vehicleStates);
        TreeMap<String, Integer> raceState = new TreeMap<String, Integer>(comparator);
        raceState.putAll(vehicleStates);
        System.out.println(raceState);
        */
    }

    private static Car[] createVehicles() {

        Car[] cars = new Car[10];
        String[] carNames = Car.createNames();
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            car.name = carNames[i];
            car.setNormalSpeed();
            cars[i] = car;
        }

        return cars;
    }

    private static boolean isRaining() {
        int rain = random.nextInt(100) + 1;
        if (rain <= 30) {
            return true;
        }
            return false;
    }

    private static Car[] simulateRace(Car[] vehicles) {

        for (int hour = 1; hour <= 50; hour++) {
            System.out.println("Hour: " + hour);
            if (isRaining()) {
                System.out.println("Raining!");
            } else {
                System.out.println("Nice and clear!");
            }
            for (int i = 0; i < 10; i++) {
                vehicles[i].moveForAnHour();
                System.out.println(vehicles[i].name + " " + vehicles[i].distanceTraveled);
            }
        }
        return vehicles;
    }

    private static void printRaceResults(Car[] vehicles) {

        Map<Integer, String> race = new TreeMap<Integer, String>();

        for (int i = 0; i < 10; i++) {
            race.put(vehicles[i].distanceTraveled, vehicles[i].name);
        }

        Map<Integer, String> result = new TreeMap<>(
                (Comparator<Integer>) (o1, o2) -> o2.compareTo(o1)
        );
        result.putAll(race);
        System.out.println(result);
    }
 }