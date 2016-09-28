package org.example.polygon;

import java.io.*;

/**
 */
public class OutputFileStreamUtils {
    private static final String OUTPUT_PATH = "./output";
    private static String getOuputPath() throws IOException {
        File file = new File(OUTPUT_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        return OUTPUT_PATH;
    }
    public static OutputStream getOutputStream(String path) throws IOException {
        File file = new File(getOuputPath().concat(path));
        if (!file.exists()) {
            file.createNewFile();
        }
        return new FileOutputStream(file);
    }
}
