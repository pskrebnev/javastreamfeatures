package myexample;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class MyPropertiesReader {
    private static final String PROPERTIES_FILE_NAME = "config.properties";

    public static void main(String[] args) {
        readPropertiesFile();
        writePropertiesFile();
    }

    private static void readPropertiesFile() {
        try (InputStream inputStream = MyPropertiesReader.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME)) {
            Properties properties = new Properties();
            properties.load(inputStream);

            System.out.println("Reading properties from " + PROPERTIES_FILE_NAME);
            System.out.println("Property1: " + properties.getProperty("property1"));
            System.out.println("Property2: " + properties.getProperty("property2"));
            System.out.println("Property3: " + properties.getProperty("property3"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writePropertiesFile() {
        try {
            Path propertiesFilePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", PROPERTIES_FILE_NAME);
            Properties properties = new Properties();
            properties.setProperty("property1", "value1");
            properties.setProperty("property2", "value2");
            properties.setProperty("property3", "value3");
            properties.setProperty("property4", "value40");
            properties.setProperty("property5", "value50");

            try (OutputStream outputStream = Files.newOutputStream(propertiesFilePath)) {
                properties.store(outputStream, "Writing properties to " + PROPERTIES_FILE_NAME);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
