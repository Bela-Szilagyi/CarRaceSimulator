package hu.codecool;

import java.util.*;


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
                .forEach(v -> result.add(String.format("%-20s", v.name) + " " + v.distanceTraveled + " " + v.getType()));

        Integer counter = 1;
        for (String vehicle: result) {
            String place = counter.toString() + ".: ";
            System.out.println(String.format("%-5s", place) + vehicle);
            counter++;
        }
    }
 }