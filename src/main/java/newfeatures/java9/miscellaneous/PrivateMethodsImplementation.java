package newfeatures.java9.miscellaneous;

public class PrivateMethodsImplementation implements PrivateMethodsInterface {
    public static void main(String[] args) {

        PrivateMethodsImplementation pmi = new PrivateMethodsImplementation();
        System.out.println(pmi.addEvenNumbers(2, 3, 4, 6));
        System.out.println(pmi.addOddNumbers(1, 3, 5, 6));
    }
}
