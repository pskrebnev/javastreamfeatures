package newfeatures.java9.optional;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalEnhancements {
    public static void main(String[] args) {

        Optional<String> msg = Optional.of("Eazy Bytes");
        Optional<String> nullMsg = Optional.ofNullable(null);

//        msg.ifPresentOrElse(word -> System.out.println(word), () -> System.out.println("None"));
//        nullMsg.ifPresentOrElse(word -> System.out.println(word), () -> System.out.println("None"));

        System.out.println("< === >");

//        Optional<String> msgValue = msg.or(() -> Optional.of("None"));
//        System.out.println(msgValue);

        System.out.println("< === >");

//        Optional<String> nullMsgValue = nullMsg.or(() -> Optional.of("None"));
//        System.out.println(nullMsgValue);

        System.out.println("< === >");
//
        Stream.of(Optional.of("Java 9")
                        , Optional.empty()
                        , Optional.of("New Features")
                        , Optional.ofNullable(null))
                .flatMap(Optional::stream).forEach(System.out::println);
    }
}
