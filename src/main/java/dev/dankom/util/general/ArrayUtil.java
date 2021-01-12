package dev.dankom.util.general;

import dev.dankom.util.Util;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil implements Util {

    public static <T> List<T> create(T... objects) {
        List<T> out = new ArrayList<>();
        for (T o : objects) {
            out.add(o);
        }
        return out;
    }

    public static <T> T[] create(List<T> objects) {
        return (T[]) objects.toArray(objects.toArray());
    }
}
