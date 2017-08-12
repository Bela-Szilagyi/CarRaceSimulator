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
    /*
    public static ArrayList getCarNames() {

        ArrayList<String> names =new ArrayList<String>();

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
            names.add(pickedFirstName + " " + pickedLastName);
        }
        return names;
    }
    */
}
