package dev.dankom.core;

import dev.dankom.file.jar.JarFile;
import dev.dankom.logger.Logger;
import dev.dankom.test.TestRunner;
import dev.dankom.util.maven.PropertiesReader;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Dankom
 */
public class Core {

    private static Logger logger;

    public Core(TestRunner runner) {
        getLogger().info("Core", "Starting Core by Dankom");
        runner.start();

        try {
            JarFile jar = new JarFile(new File("./"), "Test");
            jar.unpackage();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Core() {
        this(new TestRunner("dev.dankom.test.tests"));
    }

    public static Logger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public static void main(String[] args) {
        new Core();
    }
}
