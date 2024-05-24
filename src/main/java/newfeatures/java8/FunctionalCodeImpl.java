package newfeatures.java8;

import java.util.Arrays;
import java.util.List;

import static newfeatures.java8.IntegerOperation.filterIntegers;

public class FunctionalCodeImpl {

    public static void main(String[] args) {
        new FunctionalCodeImpl().run();
        System.out.println();
    }

    private void run() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filter even numbers
        List<Integer> evenNumbers = filterIntegers(numbers, n -> n % 2 == 0);
        System.out.println(evenNumbers);

        // Filter numbers greater than 5
        List<Integer> greaterThanFive = filterIntegers(numbers, n -> n > 5);
        System.out.println(greaterThanFive);

        // Filter numbers using a method reference
        List<Integer> nonNegative = filterIntegers(numbers, n -> n >= 0);
        System.out.println(nonNegative);
    }
}
