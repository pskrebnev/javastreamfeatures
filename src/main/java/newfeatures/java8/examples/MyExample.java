package newfeatures.java8.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyExample {

    public static void test() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> uppercaseNames = names.stream()
                .map(Function.identity()) // No transformation
                .collect(Collectors.toList());
        System.out.println(uppercaseNames);
    }

    public static void main(String[] args) {
        test();
    }
}



