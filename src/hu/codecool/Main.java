package hu.codecool;

import sun.awt.datatransfer.DataTransferer;

import java.util.*;
import java.util.stream.Collectors;

import static hu.codecool.Motorcycle.createName;

public class Main {

    static Random random = new Random();


    public static void main(String[] args) {
        
        Car.setSpeedLimit(110);
        // Car[] vehicles = createVehicles();
        Vehicle[] vehicles = createVehicles();
        vehicles = simulateRace(vehicles);
        printRaceResults(vehicles);

    }

    private static Vehicle[] createVehicles() {

        Vehicle[] vehicles = new Vehicle[30];

        String[] carNames = Car.createNames();
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            car.name = carNames[i];
            car.setNormalSpeed();
            vehicles[i] = car;
        }

        for (int i = 10; i < 20; i++) {
            Motorcycle moto = new Motorcycle();
            moto.name = Motorcycle.createName();
            vehicles[i] = moto;
        }

        for (int i = 20; i < 30; i++) {
            Truck truck = new Truck();
            truck.name = Truck.createName();
            vehicles[i] = truck;
        }

        return vehicles;
    }

    private static boolean isRaining() {
        int rain = random.nextInt(100) + 1;
        if (rain <= 30) {
            return true;
        }
            return false;
    }

    private static Vehicle[] simulateRace(Vehicle[] vehicles) {

        // int[] raceStat = new int[500];

        for (int hour = 1; hour <= 50; hour++) {
            /*
            if (isRaining()) {
                // System.out.println("Raining!");
            } else {
                // System.out.println("Nice and clear!");
            }
            */
            for (int i = 0; i < 30; i++) {
                vehicles[i].moveForAnHour(isRaining());
                // raceStat[(hour-1)*10+i] = (vehicles[i].distanceTraveled);
            }
        }
        return vehicles;
    }

    private static void printRaceResults(Vehicle[] vehicles) {

        List<Vehicle> racers = new ArrayList<>();
        for (Vehicle vehicle: vehicles){
            racers.add(vehicle);
        }

        List<String> result = new ArrayList<>();
        racers.stream()
                .sorted(Comparator.comparing(Vehicle::getDistanceTraveled).reversed())
                .forEach(v -> result.add(v.name + " " + v.distanceTraveled + " " + v.getType()));

        int counter = 0;
        for (String vehicle: result) {
            System.out.println(++counter + ".: " + vehicle);
        }
    }
 }