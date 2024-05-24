package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadResourceFile {
    public static void main(String[] args) {
        try (InputStream input = ReadResourceFile.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            if (input != null) {
                prop.load(input);
                System.out.println(prop.getProperty("db.url"));
            } else {
                System.out.println("Unable to find config.properties");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
