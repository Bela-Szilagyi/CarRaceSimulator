package hu.codecool;

import java.util.*;

public class Logic {


    /*
        for (int j = 0; j < vehicles[i].distanceTraveled / 100; j++) {
        System.out.print('*');
    }
    try {
        Runtime.getRuntime().exec("clear");
    } catch (IOException e) {
        e.printStackTrace();
    }

    */

    public static class ValueComparator implements Comparator {

        Map map;

        public ValueComparator(Map map) {
            this.map = map;
        }

        public int compare(Object keyA, Object keyB) {
            Comparable valueA = (Comparable) map.get(keyA);
            Comparable valueB = (Comparable) map.get(keyB);
            return valueB.compareTo(valueA);
        }
    }
}
