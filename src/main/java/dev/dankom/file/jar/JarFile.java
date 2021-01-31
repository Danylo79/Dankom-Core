package dev.dankom.file.jar;

import dev.dankom.file.jar.runner.Runner;

import java.io.File;
import java.io.FileNotFoundException;

public class JarFile {

    private File jar;

    public JarFile(File path, String name) throws FileNotFoundException {
        File jar = new File(path, name);
        if (jar.exists()) {
            this.jar = jar;
        } else {
            throw new FileNotFoundException("Jar file not found " + jar.getAbsolutePath() + "!");
        }
    }

    public void run(String... args) {
        Runner.run(jar, args);
    }
}
