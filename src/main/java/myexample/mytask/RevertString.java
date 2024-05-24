package myexample.mytask;

public class RevertString {

    public static void main(String[] args) {
        String st = "Because notes are plain text files";
        System.out.println("Initial string:\n" + st);
        System.out.println("Reverted with StringBuilder:\n" + revertStr(st));
        System.out.println("Reverted with Stream:\n" + revertStrWithStream(st));
    }

    private static String revertStr(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    private static String revertStrWithStream(String str) {
        return str.codePoints()
                .mapToObj(c -> (char) c)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .reverse()
                .toString();
    }
}
