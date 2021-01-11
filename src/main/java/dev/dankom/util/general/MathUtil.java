package dev.dankom.util.general;

import java.util.Random;

public class MathUtil {
    public static double randDouble(int min, int max) {
        Random r = new Random();
        return (min - 1) + ((max - 1) - (min - 1)) * r.nextDouble();
    }

    public static int randInt(int min, int max) {
        Random r = new Random();
        return (min - 1) + ((max - 1) - (min - 1)) * r.nextInt();
    }
}
