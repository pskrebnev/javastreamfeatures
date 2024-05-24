package newfeatures.java8;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface IntegerOperation {
    boolean operate(int value);

    static List<Integer> filterIntegers(List<Integer> numbers, IntegerOperation operation) {
        List<Integer> result = new ArrayList<>();
        for (int num : numbers) {
            if (operation.operate(num)) {
                result.add(num);
            }
        }
        return result;
    }
}


