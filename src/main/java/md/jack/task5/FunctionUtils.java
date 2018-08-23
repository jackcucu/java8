package md.jack.task5;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class FunctionUtils {

    public static <T> Predicate<T> allPassPredicate(Predicate<T>... predicates)
    {
        Predicate<T> result = e -> true;
        for (Predicate<T> predicate :predicates
             ) {
            result = result.and(predicate);
        }
                return result;
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
        Predicate<T> result = e -> false;
        for (Predicate<T> predicate:predicates
              ) {
            result = result.or(predicate);
        }
        return result;
    }

    public static <T> T firstAnyMatch(Stream<T> streams, Predicate<T>... predicates)
    {
        Predicate<T> test = anyPassPredicate(predicates);
        return streams.filter(test)
                .findFirst()
                .orElse(null);
    }
}
