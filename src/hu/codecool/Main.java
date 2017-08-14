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
        Motorcycle[] vehicles = createVehicles();
        vehicles = simulateRace(vehicles);
        printRaceResults(vehicles);

    }

    private static Motorcycle[] createVehicles() {

        /*
        Car[] cars = new Car[10];
        String[] carNames = Car.createNames();
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            car.name = carNames[i];
            car.setNormalSpeed();
            cars[i] = car;
        }
        return cars;
        */
        Motorcycle[] motos = new Motorcycle[10];
        for (int i = 0; i < 10; i++) {
            Motorcycle moto = new Motorcycle();
            moto.name = createName();
            motos[i] = moto;
        }
        return motos;
    }

    private static boolean isRaining() {
        int rain = random.nextInt(100) + 1;
        if (rain <= 30) {
            return true;
        }
            return false;
    }

    private static Motorcycle[] simulateRace(Motorcycle[] vehicles) {

        // int[] raceStat = new int[500];

        for (int hour = 1; hour <= 50; hour++) {
            /*
            if (isRaining()) {
                // System.out.println("Raining!");
            } else {
                // System.out.println("Nice and clear!");
            }
            */
            for (int i = 0; i < 10; i++) {
                vehicles[i].moveForAnHour(isRaining());
                // raceStat[(hour-1)*10+i] = (vehicles[i].distanceTraveled);
            }
        }
        return vehicles;
    }

    private static void printRaceResults(Motorcycle[] vehicles) {

        List<Motorcycle> motos = new ArrayList<>();
        for (Motorcycle moto: vehicles){
            motos.add(moto);
        }

        List<String> result = new ArrayList<>();
        motos.stream()
                .sorted(Comparator.comparing(Motorcycle::getDistanceTraveled).reversed())
                .forEach(v -> result.add(v.name + " " + v.distanceTraveled));

        int counter = 0;
        for (String vehicle: result) {
            System.out.println(++counter + ".: " + vehicle);
        }
    }
 }