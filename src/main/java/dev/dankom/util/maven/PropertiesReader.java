package dev.dankom.util.maven;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private Properties properties;

    public PropertiesReader(String propertyFileName) throws IOException {
        InputStream is = getClass().getClassLoader()
                .getResourceAsStream(propertyFileName);
        this.properties = new Properties();
        this.properties.load(is);
    }

    public String getProperty(String propertyName) {
        return this.properties.getProperty(propertyName);
    }

    public static String get(String name) {
        PropertiesReader reader = null;
        try {
            reader = new PropertiesReader("maven-properties.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reader.getProperty(name);
    }

    public static String getCompilerSource() {
        return get("maven.compiler.source");
    }

    public static String getCompilerTarget() {
        return get("maven.compiler.target");
    }

    public static String getProjectBuildDir() {
        return get("dev.dankom.outputDir");
    }

    public static String getJar(String version) {
        return "https://github.com/" + get("dev.dankom.github.username") + "/" + get("dev.dankom.github.repository") + "/releases/download/" + version + "/Dankom-Core-" + version + ".jar";
    }
}
