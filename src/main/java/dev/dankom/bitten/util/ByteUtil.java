package dev.dankom.bitten.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteUtil {
    public static void save(String name, File path, byte[] bytes) throws IOException {
        FileOutputStream out = new FileOutputStream(path.getAbsolutePath() + "/" + name + ".class");
        out.write(bytes);
        out.close();
    }
}
