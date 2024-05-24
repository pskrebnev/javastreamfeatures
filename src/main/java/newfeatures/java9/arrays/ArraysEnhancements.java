package newfeatures.java9.arrays;

import java.util.Arrays;

public class ArraysEnhancements {
    public static void main(String[] args) {
//        misMatch();
//        compare();
        equals();
    }

    private static void misMatch() {
        int res = Arrays.mismatch(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5});
        System.out.println("Bewtween arrays: " + res);
        res = Arrays.mismatch(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 6, 5});
        System.out.println("Bewtween arrays: " + res);
    }

    private static void compare() {
//        int res = Arrays.compare(new int[]{1}, new int[]{1});
//        System.out.println(res); // 0 in case arrays are equal

        int resIndex = Arrays.compare(new String[]{"Eazy", "Bytes"}, new String[]{"Hello", "Eazy", "Bytes"});
        System.out.println(resIndex);


        // distance between 'A' and 'C' is '-2'
//        System.out.println(Arrays.compare(new String[]{"ABCDEFG"}, new String[]{"CDEFGH"}));
    }

    private static void equals() {

        boolean result = Arrays.equals(new String[]{"Eazy", "Bytes"}, new String[]{"Eazy", "Bytes"});
        System.out.println(result);

        result = Arrays.equals(new String[]{"Eazy", "Bytes"}, new String[]{"Eazy", "Bytes", "Java9"});
        System.out.println(result);

        result = Arrays.equals(new String[]{"Eazy", "Bytes"}, 0, 1, new String[]{"Eazy", "Bytes", "Java9"}, 0, 1);
        System.out.println(result);
    }
}
