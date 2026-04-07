import java.util.*;
import java.util.function.*;

public class StringProcessor {
    public static void processStrings(List<String> strings,
            Predicate<String> filter,
            Function<String, String> transformer,
            Consumer<String> printer) {
        for (String s : strings) {
            if (filter.test(s)) {
                printer.accept(transformer.apply(s));
            }
        }
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Програмчлал", "Код");

        Predicate<String> lengthFilter = s -> s.length() > 5;
        Function<String, String> reverser = s -> new StringBuilder(s).reverse().toString();
        Consumer<String> printer = s -> System.out.println("ГАРШИЛ: " + s.toUpperCase());

        processStrings(words, lengthFilter, reverser, printer);
    }
}

