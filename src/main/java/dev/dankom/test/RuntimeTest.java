package dev.dankom.test;

import dev.dankom.logger.Logger;

import java.lang.reflect.Method;

public class RuntimeTest {

    protected Logger logger;

    public RuntimeTest() {
        this.logger = new Logger();
    }

    public void run() {
        Class<?> clazz = getClass();
        for (Method m : clazz.getDeclaredMethods()) {
            try {
                if (m.isAnnotationPresent(Test.class)) {
                    m.invoke(this);
                }
            } catch (Exception e) {
                logger.error("Test-Manager", "Failed to run test " + m.getName() + " because of " + e.getClass().getSimpleName() + "!");
            }
        }
    }
}
