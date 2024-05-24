package newfeatures.java8.streamsapi;

import utils.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {
    public static void main(String[] args) {
//        parallelStreams();
//        flatMapInStreams();
//        filterInStreams();
//        collectStreams();
//        collectingAndThenStreams();
//        groupingByStreams();
//        partitioningByStreams();
        streamPipeline();
    }

    public static void mapInStreams() {
        List<String> departmentList = new ArrayList<>();
        departmentList.add("Supply");
        departmentList.add("HR");
        departmentList.add("Sales");
        departmentList.add("Marketing");

        departmentList.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    public static void flatMapInStreams() {
        String[] arrayOfWords = {"Eazy", "Bytes"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        /*
         * streamOfwords.map(word ->
         * word.split("")).flatMap(Arrays::stream).forEach(System.out::println);
         */
        streamOfwords.map(word -> word.split("")).flatMap(Arrays::stream).forEach(System.out::println);
//        Stream<String[]> streamOfLetters = streamOfwords.map(word ->word.split(""));
//        streamOfLetters.flatMap(Arrays::stream).forEach(System.out::println);


//        List<List<String>> list = Arrays.asList( Arrays.asList("Eazy"),
//                Arrays.asList("Bytes"));
//        System.out.println(list);
//        list.stream().map(Collection::stream).forEach(System.out::println);
//        list.stream().flatMap(Collection::stream).forEach(System.out::println);

    }

    public static void filterInStreams() {
        List<String> departmentList = new ArrayList<>();
        departmentList.add("Supply");
        departmentList.add("HR");
        departmentList.add("Sales");
        departmentList.add("Marketing");

        departmentList.stream().filter(word -> word.startsWith("S")).forEach(System.out::println);
    }

    public static void traverseOnceInStreams() {
        try {
            List<String> departmentList = new ArrayList<>();
            departmentList.add("Supply");
            departmentList.add("HR");
            departmentList.add("Sales");
            departmentList.add("Marketing");
            Stream<String> depStream = departmentList.stream();
            depStream.forEach(System.out::println);
            depStream.forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void limitInStreams() {
        Stream.generate(new Random()::nextInt).limit(10).forEach(System.out::println);
    }

    public static void skipInStreams() {
        Stream.iterate(1, n -> n + 1).skip(10).limit(20).forEach(System.out::println);
    }

    public static void reduceInStreams() {
        System.out.println(Stream.iterate(1, n -> n + 1).limit(20).reduce(0, (a, b) -> a + b));
    }

    public static void maxInStreams() {
        System.out.println(Stream.iterate(1, n -> n + 1).limit(20).max((a, b) -> a + b));
    }

    public static void collectStreams() {
        List<String> departmentList = new ArrayList<>();
        departmentList.add("Supply");
        departmentList.add("HR");
        departmentList.add("Sales");
        departmentList.add("Marketing");

        Stream<String> depStream = departmentList.stream();
        depStream.filter(word -> word.startsWith("S")).toList().forEach(System.out::println);
    }

    public static void collectingAndThenStreams() {
        List<Product> productList = Arrays.asList(new Product("Apple", 1200)
                , new Product("Samsung", 1000)
                , new Product("Nokia", 8000)
                , new Product("BlackBerry", 1000)
                , new Product("Apple Pro Max", 1500)
                , new Product("Mi", 800), new Product("OnePlus", 1000));

        String maxPriceProduct = productList.stream()
                .collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Product::getPrice))
                        , (Optional<Product> product) -> product.isPresent() ? product.get().getName() : "None"));
        System.out.println("The product with max price tag is: " + maxPriceProduct);
    }

    public static void groupingByStreams() {
        List<Product> productList = Arrays.asList(new Product("Apple", 1200), new Product("Samsung", 1000),
                new Product("Nokia", 800), new Product("BlackBerry", 1000), new Product("Apple Pro Max", 1500),
                new Product("Mi", 800), new Product("OnePlus", 1000));

        Map<Integer, List<Product>> groupByPriceMap = productList.stream()
                .collect(Collectors.groupingBy(Product::getPrice));
        System.out.println("The list of products grouped by price is: " + groupByPriceMap);
    }

    public static void partitioningByStreams() {
        List<Product> productList = Arrays.asList(new Product("Apple", 1200), new Product("Samsung", 1000),
                new Product("Nokia", 800), new Product("BlackBerry", 1000), new Product("Apple Pro Max", 1500),
                new Product("Mi", 800), new Product("OnePlus", 1000));

        Map<Boolean, List<Product>> costlyProducts = productList.stream()
                .collect(Collectors.partitioningBy(product -> product.getPrice() > 1000));
        System.out.println("The list of products partitioned by price is: " + costlyProducts);
    }

    public static void parallelStreams() {
        List<String> departmentList = new ArrayList<>();
        departmentList.add("Supply");
        departmentList.add("HR");
        departmentList.add("Sales");
        departmentList.add("Marketing");
        departmentList.add("Insurance");
        departmentList.add("Security");
        departmentList.add("Finance");

        departmentList.parallelStream().forEach(System.out::println);

    }

    private static void streamPipeline() {
        List<Integer> inputNums = Arrays.asList(5, 2, 11, 7, 4, 13, 9);

        inputNums.stream()
                .filter(num -> num % 2 != 0)
                .map(num -> num * num)
                .sorted()
                .toList()
                .forEach(System.out::println);
    }
}
