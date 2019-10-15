package Jugs;

import java.util.ArrayList;
import java.util.List;

public class App {

    private static List<Integer> sols;

    public static void main(String[] args) {
        int num1 = 9; int num2 = 12;
        sols = new ArrayList<Integer>();

        // --------------------------------------

        sols.add(0);
        sols.add(num1);
        sols.add(num2);

        List<Integer> keyNums = getKeyNums(num1, num2);

        for (Integer num : keyNums) {
            for (int i = (num2 - num); i > 0; i -= num1) {
                if (!sols.contains(i)) {
                    sols.add(i);
                }
            }
        }

        sols.sort((e1, e2) -> {
            return e1 - e2;
        });
    }

    public static List<Integer> getKeyNums(int num1, int num2) {
        List<Integer> keyNums = new ArrayList<Integer>();
        int k = num1;
        while(true) {

            if (!keyNums.contains(k)) {
                keyNums.add(k);
            } else {
                return keyNums;
            }

            k = num1 - ((num2 - k) % num1);
        }
    }

    public class Jug {

        private String name;

        private int water;
        private int capacity;

        public Jug(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
            fill();
        }

        public String fill() {
            this.water = this.capacity;
            return "Fill " + this.name;
        }

        public String empty() {
            this.water = 0;
            return "Empty " + this.name;
        }

        public String pour_into(Jug other) {
            if (other.getSpace() > this.water) {
                other.addWater(this.water);
                this.empty();
            } else { 
                this.water -= other.getSpace();
                other.fill();
            }
            return "Pour " + this.name + "into" + other.getName();
        }

        private void addWater(int water) {
            if (water < 0) {
                throw new Error("Encountered negative water");
            }
            int temp = this.water + water;
            this.water = (temp > this.capacity) ? this.capacity : temp;
        }

        public String getName() {
            return this.name;
        }

        public int getWater() {
            return this.water;
        }

        public int getSpace() {
            return this.capacity - this.water;
        }
    }
}
