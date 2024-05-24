package myexample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyNewFileReader {
    public static void main(String[] args) throws IOException {
        // Specify the folder path where you want to create the file
        String folderPath = "src/test/resources";

        // Specify the file name
        String fileName = "example.txt";

        // Create the file path by combining the folder path and file name
        Path filePath = Paths.get(folderPath, fileName);

        // in case I want to create the folder if it doesn't exist
        /* try {
            Path folderPathObj = Paths.get(folderPath);
            if (!Files.exists(folderPathObj)) {
                Files.createDirectories(folderPathObj);
            }
        } catch (NoSuchFileException e) {
            e.printStackTrace();
        } */

        // Create the file
        try {
            Files.createFile(filePath);
            System.out.println("File created: " + filePath);
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
            return;
        }

        // Write content to the file
        String content = "This is an example content.";
        try {
            Files.write(filePath, content.getBytes());
            System.out.println("Content written to file.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
