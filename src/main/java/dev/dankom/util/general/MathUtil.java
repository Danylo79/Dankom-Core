package dev.dankom.util.general;

import dev.dankom.util.Util;

import java.text.DecimalFormat;
import java.util.Random;

public class MathUtil implements Util {
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

    public static double convertDoubleToThousand(double num) {
        return num * 1000;
    }

    public static double convertDoubleToMillion(double num) {
        return num * 1000000;
    }

    public static double convertDoubleToBillion(double num) {
        return num * 1000000000;
    }

    public static String formatLargeDouble(double Double) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###,###.###");
        String out = decimalFormat.format(Double);

        return out;
    }
}
