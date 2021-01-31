package dev.dankom.dct;

import dev.dankom.file.type.Directory;
import dev.dankom.file.yml.YmlFile;
import dev.dankom.file.yml.YmlObjectBuilder;

public class Main {

    public Directory root = new Directory("./dankom-core");

    public Main() {
        try {
            YmlFile ymlTest = new YmlFile(root, "test", new YmlObjectBuilder().put("test", "test").build());
            System.out.println(ymlTest.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
