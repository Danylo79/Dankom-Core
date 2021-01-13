package dev.dankom.util.general;

import java.text.DecimalFormat;
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

    public static int getPercent(int num1, float perc) {
        return Math.round((perc * num1) / 100f);
    }

    public static Double percOf(Integer number1, Integer prec) {
        return number1 * prec / 100.0;
    }

    public static Double percOf(Double number1, Integer prec) {
        return number1 * prec / 100.0;
    }
}
