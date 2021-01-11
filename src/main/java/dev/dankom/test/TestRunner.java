package dev.dankom.test;

import dev.dankom.core.Core;
import dev.dankom.logger.Logger;
import dev.dankom.util.reflection.ReflectionUtil;

public class TestRunner {

    public Logger logger;
    private String[] testRunners;

    public TestRunner(String... testRunners) {
        this.testRunners = testRunners;
    }

    public void start() {
        this.logger = Core.getLogger();
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
}
