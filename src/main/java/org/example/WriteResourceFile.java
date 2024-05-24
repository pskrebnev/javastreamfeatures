package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class WriteResourceFile {
    public static void main(String[] args) {
        try (InputStream input = WriteResourceFile.class.getClassLoader().getResourceAsStream("template.txt")) {
            if (input != null) {
                Path tempFile = Files.createTempFile("prefix", ".txt");
                Files.copy(input, tempFile, StandardCopyOption.REPLACE_EXISTING);
                // Do something with the tempFile
            } else {
                System.out.println("Unable to find template.txt");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
