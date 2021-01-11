package dev.dankom.test;

import dev.dankom.logger.Logger;
import dev.dankom.util.reflection.ReflectionUtil;

public class TestRunner {

    public Logger logger;

    public TestRunner(String... testRunners) {
        this.logger = new Logger();
        logger.test("TestRunner", "Starting TestRunner");
        for (String dir : testRunners) {
            for (Class<? extends RuntimeTest> test : ReflectionUtil.getAllClasses(dir, RuntimeTest.class)) {
                try {
                    RuntimeTest testInstance = test.newInstance();
                    testInstance.run();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new TestRunner("dev.dankom.test.tests");
    }
}
