package dev.dankom.util.general;

import dev.dankom.util.Util;

public class StringFormatter implements Util {
    public static String join(String... strings) {
        String out = "";
        for (String s : strings) {
            out += s;
        }
        return out;
    }
}
