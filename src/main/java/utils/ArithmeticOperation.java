package utils;

@FunctionalInterface
public interface ArithmeticOperation {
    int performOperation(int a, int b);

    default void performAdd(int a, int b) {
        System.out.println(Math.addExact(a, b));
    }

    static void printTheInput(int res) {
        System.out.println(res);
    }
}
