package Jugs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        int[] jug_sizes = {4, 8, 21};

        int s = 5;

        // ----------------------------------------------------------------------------

        Arrays.sort(jug_sizes);

        List<Jug> jugs = new ArrayList<Jug>();
        for (Integer size : jug_sizes) {
            jugs.add(new Jug(size + "Jug", size));
        }

        if (isSolution(s, jug_sizes[0], Arrays.copyOfRange(jug_sizes, 1, jug_sizes.length))) {
            // List<String> steps = getSolution(s, j1, j2);
            // for (String step : steps) {
            //     System.out.println(step);
            // }
            System.out.println("solution exists");
        } else {
            System.out.println("no solution");
        }
    }

    public static List<String> getSolution(int sol, Jug j1, Jug j2) {
        List<String> steps = new ArrayList<String>();
        if (sol == 0) {
            steps.add("JUST EMPTY ANY JUG");
        }
        
        while (true) {
            steps.add(j2.fill());
            if (j2.getWater() == sol) return steps;

            while (j2.getWater() != 0) {

                steps.add(j2.pour_into(j1));
                if ((j1.getWater() == sol) || (j2.getWater() == sol)) return steps;
                
                if (j1.getSpace() == 0) {
                    steps.add(j1.empty());
                }
            }
        }
    }

    public static boolean isSolution(int sol, int num1, int... nums) {
        if (sol == 0) {
            return true;
        } else {
            return ((sol % getGCD(num1, nums)) == 0);
        }
    }

    public static int getGCD(int num1, int... nums) {
        int gcd = num1;

        if (nums == null) {
            return gcd;
        }

        int len = Array.getLength(nums);
        for (int i = 0; i < len; i++) {
            gcd = getGCD(gcd, nums[i]);
            if (gcd == 1) {
                return gcd;
            }
        }

        return gcd;
    }

    public static int getGCD(int num1, int num2) {
        while (num1 != num2) {
        	if(num1 > num2)
                num1 = num1 - num2;
            else
                num2 = num2 - num1;
        }
        return num2;
    }
}
