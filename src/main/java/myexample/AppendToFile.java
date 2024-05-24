package myexample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AppendToFile {
    public static void main(String[] args) {
        // Specify the folder path and file name
        String folderPath = "src/test/resources";
        String fileName = "example.txt";
        Path filePath = Paths.get(folderPath, fileName);

        // Content to append
        String contentToAppend = "\nThis is additional content. \nSay you bla-bla";

        try {
            // Append the content to the file
            Files.write(filePath, contentToAppend.getBytes(), StandardOpenOption.APPEND);
            System.out.println("Content appended to file.");
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
        }
    }
}
