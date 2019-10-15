package Jugs;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        int num1 = 153; int num2 = 256;

        int s = 255;

        Jug j1 = new Jug("JugOne", num1);
        Jug j2 = new Jug("JugTwo", num2);

        if (isSolution(s, num1, num2)) {
            List<String> steps = getSolution(s, j1, j2);
            for (String step : steps) {
                System.out.println(step);
            }
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

    public static boolean isSolution(int sol, int num1, int num2) {
        if (sol == 0) {
            return true;
        } else {
            return ((sol % getGCD(num1, num2)) == 0);
        }
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
