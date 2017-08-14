package hu.codecool;

import sun.awt.datatransfer.DataTransferer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static Random random = new Random();


    public static void main(String[] args) {
        
        Car.setSpeedLimit(110);
        Car[] vehicles = createVehicles();
        vehicles = simulateRace(vehicles);
        printRaceResults(vehicles);

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

        int[] raceStat = new int[500];

        for (int hour = 1; hour <= 50; hour++) {
            if (isRaining()) {
                // System.out.println("Raining!");
            } else {
                // System.out.println("Nice and clear!");
            }
            for (int i = 0; i < 10; i++) {
                vehicles[i].moveForAnHour();
                raceStat[(hour-1)*10+i] = (vehicles[i].distanceTraveled);
            }
        }
        /*
        int counter = 0;
        for (int hour = 1; hour < 50; hour++) {
            for (int i = 0; i < 10; i++) {
                counter = 0;
                for (int s = 0; s < raceStat[(hour-1)*10+i]/100; s++) {
                    // System.out.print('*');
                    counter++;
                }
                // System.out.println(counter);
            }
            // TimeUnit.SECONDS.sleep(1);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < counter; i++) {
                // System.out.print("\b");
            }

            // System.out.println();
        }
        */
        return vehicles;
    }

    private static void printRaceResults(Car[] vehicles) {

        List<Car> cars = new ArrayList<>();
        for (Car car: vehicles){
            cars.add(car);
        }

        List<String> result = new ArrayList<>();
        cars.stream()
                .sorted(Comparator.comparing(Car::getDistanceTraveled).reversed())
                .forEach(c -> result.add(c.name + " " + c.distanceTraveled));

        int counter = 0;
        for (String car: result) {
            System.out.println(++counter + ".: " + car);
        }
    }
 }