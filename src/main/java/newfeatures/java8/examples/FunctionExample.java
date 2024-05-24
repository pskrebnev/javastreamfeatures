package newfeatures.java8.examples;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {

        // Creating a Function
        Function<String, String> convertStr = input -> input.toUpperCase();

        // Calling Function method
        System.out.println("The uppercase value of given input is : " + convertStr.apply("Eazy Bytes"));

        Function<String, String> sameValue = Function.identity();

        // Calling Function method
        System.out.println("Function.identity() example: The value of given input is : " + sameValue.apply("Eazy Bytes"));

        Function<Integer, Integer> multiplyOperation = a -> {
            System.out.println("Double Operation");
            return a * 2;
        };

        // Chaining the function methods using andThen()
        multiplyOperation = multiplyOperation.andThen(a -> {
            System.out.println("Triple Operation");
            return 3 * a;
        });

        System.out.println("Input is 5, output is: " + multiplyOperation.apply(5));

        Function<Integer, Integer> divOperation = a -> {
            System.out.println("Division by 2 Operation");
            return a / 2;
        };

        // Chaining the function methods using compose()
        divOperation = divOperation.compose(a -> {
            System.out.println("Division by 3 Operation");
            return a / 3;
        });

        System.out.println(divOperation.apply(30));
    }
}
