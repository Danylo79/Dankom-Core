package dev.dankom.bitten.interfaces.generator;

import java.io.File;

public interface IClassGenerator {
    void generate(String name, File path);

    default void generate(String name, String path) {
        generate(name, new File(path));
    }
}
