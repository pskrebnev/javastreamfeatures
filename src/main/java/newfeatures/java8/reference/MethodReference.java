package newfeatures.java8.reference;

import utils.ArithmeticOperation;
import utils.Product;
import utils.ProductInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MethodReference {
    public static void main(String[] args) {
//        staticMethodReference();
//        instanceMethodObjReference();
//        instanceMethodWithClassName();
//        constructorReference();
//        Stream.generate(Math::random).limit(20).forEach(System.out::println);
//        Stream.iterate(5, n -> n + 5).limit(10).forEach(System.out::println);

        System.out.println(Stream.iterate(1, n -> n + 1).limit(20).reduce(0, Integer::sum));
    }

    public static void constructorReference() {
        ProductInterface productUsingLambda = (name, price) -> new Product(name, price);
        Product prodSamsung = productUsingLambda.getProduct("Samsung Galaxy", 1000);
        System.out.println(prodSamsung);

        ProductInterface productUsingRef = Product::new;
        Product prodApple = productUsingRef.getProduct("Apple IPhone", 1500);
        System.out.println(prodApple.toString());
    }

    public static void instanceMethodWithClassName() {
        List<String> departmentList = new ArrayList<>();
        departmentList.add("Supply");
        departmentList.add("HR");
        departmentList.add("Sales");
        departmentList.add("Marketing");
        departmentList.forEach(System.out::println);

        departmentList.forEach(System.out::println);
    }

    public static void instanceMethodObjReference() {
        ArithmeticOperation operation = (a, b) -> {
            int sum = a + b;
            System.out.println("The sum of given input values " + "using lambda is: " + sum);
            return sum;
        };
        operation.performOperation(2, 3);
        MethodReference methodRef = new MethodReference();
        ArithmeticOperation instanceMethod = methodRef::performInstanceAddition;
        instanceMethod.performOperation(2, 3);
    }

    public int performInstanceAddition(int a, int b) {
        int sum = a + b;
        System.out.println("The sum of given input values using instance " + "method reference is: " + sum);
        return sum;
    }

    public static void staticMethodReference() {
        ArithmeticOperation operation = (a, b) -> {
            int sum = Math.addExact(a, b);
            System.out.println("The sum of given input values using lambda is: " + sum);
            return sum;
        };
        operation.performOperation(2, 3);

        ArithmeticOperation methodRef = MethodReference::performAddition;
        methodRef.performOperation(2, 3);
    }

    public static int performAddition(int a, int b) {
        int sum = a + b;
        System.out.println("The sum of given input values using static method reference is: " + sum);
        return sum;
    }


}
