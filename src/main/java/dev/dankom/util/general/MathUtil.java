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

    public static double clamp(double min, double max, double value) {
        double out = value;
        if (value < min) {
            out = (out + (min - out));
        }
        if (value > max) {
            out = (out - (max - out));
        }
        return out;
    }
}
