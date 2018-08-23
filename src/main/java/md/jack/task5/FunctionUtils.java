package md.jack.task5;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FunctionUtils {

    public static <T> Predicate<T> allPassPredicate(Predicate<T>... predicates)
    {
       return Arrays.asList(predicates).stream()
                .reduce(Predicate::and)
                .orElse(t->true);
    }

    public static <T> T  firstAllMatch(Stream<T> streams, Predicate<T>... predicates)
    {
        Predicate<T> test = allPassPredicate(predicates);
        return streams.filter(test)
                .findFirst()
                .orElse(null);
    }

    public static <T> Predicate<T> anyPassPredicate(Predicate<T>... predicates)
    {
        return Arrays.asList(predicates).stream()
                .reduce(Predicate::or)
                .orElse(t->false);
    }

    public static <T> T firstAnyMatch(Stream<T> streams, Predicate<T>... predicates)
    {
        Predicate<T> test = anyPassPredicate(predicates);
        return streams.filter(test)
                .findFirst()
                .orElse(null);
    }
}
