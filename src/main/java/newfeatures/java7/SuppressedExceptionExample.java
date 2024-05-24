package newfeatures.java7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SuppressedExceptionExample {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("nonexistent.txt"))) {
            // Read from the file
            String line = br.readLine();
            System.out.println("New line is = " + line);
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());

            // Print suppressed exceptions
            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("Suppressed exception: " + suppressed.getMessage());
            }
        }
    }
}
