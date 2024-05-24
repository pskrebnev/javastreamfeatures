package newfeatures.java9.streams;

import java.util.List;
import java.util.stream.Stream;

public class StreamEnhancements {
    public static void main(String[] args) {

//        Stream<String> emptyStream = Stream.ofNullable("");
//        System.out.println(emptyStream.count());
//        Stream<String> nullStream = Stream.ofNullable(null);
//        System.out.println(nullStream.count());

//        List<Integer> dropNums = Stream.of(1, 2, 3, 4, 5, 6).dropWhile(i -> i % 2 != 0)
//                .toList();
//        System.out.println(dropNums);

//        List<String> dropString = Stream.of("Eazy", "Bytes", "Java", "Blankman")
//                .dropWhile(word -> word.startsWith("B")).toList();
//        System.out.println(dropString);

        List<Integer> takeNums = Stream.of(1, 3, 4, 5, 6).takeWhile(i -> i % 2 != 0)
                .toList();
        System.out.println(takeNums);

        List<String> takeString = Stream.of("Eazy", "Eat", "England", "Java")
                .takeWhile(word -> word.startsWith("E")).toList();
        System.out.println(takeString);

        // Create a stream of integers
        Stream<Integer> numbers = Stream.of(2, 4, 5, 6, 7, 8, 9, 10);
        // Use takeWhile to create a new stream with elements until the condition is met
        numbers.takeWhile(n -> n % 2 == 0).forEach(System.out::println);
        // Print the elements of the new stream

        List<Integer> numStream = Stream.iterate(10, i -> i <= 100, i -> i + 2).toList();
        System.out.println(numStream);
        System.out.println(numStream.size());
    }
}
