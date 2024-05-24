package newfeatures.java8.examples;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();
        wordCount.put("apple", 2);
        wordCount.put("banana", 1);
        wordCount.put("cherry", 3);
        wordCount.put("orange", 4);

        // Increment the count for "apple" if it's present
        wordCount.computeIfPresent("apple", (word, count) -> count + 1);

        // Increment the count for "orange" (not present)
        wordCount.computeIfPresent("orange", (word, count) -> count + 1);

        System.out.println(wordCount);
    }
}
