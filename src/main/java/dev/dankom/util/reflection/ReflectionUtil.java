package dev.dankom.util.reflection;

import org.reflections.Reflections;

import java.util.Set;

public class ReflectionUtil {
    public static <T> Set<Class<? extends T>> getAllClasses(String dir, Class<T> type) {
        Reflections reflection = new Reflections(dir);
        return reflection.getSubTypesOf(type);
    }

    public static <T> Set<Class<?>> getAllClasses(String dir) {
        return getAllClasses(dir, Object.class);
    }

    public static <T> Set<String> getAllTypes(String dir) {
        Reflections reflection = new Reflections(dir);
        return reflection.getAllTypes();
    }
}
