package md.jack.task5;

import java.util.function.Predicate;
import java.util.stream.Stream;

class FunctionUtils
{

    private static <T> Predicate<T> allPassPredicate(final Predicate<T>... predicates)
    {
        return Stream.of(predicates)
                .reduce(Predicate::and)
                .orElse(t->true);
    }

    @SafeVarargs
    private static <T> T firstAllMatch(final Stream<T> streams, final Predicate<T>... predicates)
    {
        final Predicate<T> test = allPassPredicate(predicates);
        return streams.filter(test)
                .findFirst()
                .orElse(null);
    }

    private static <T> Predicate<T> anyPassPredicate(final Predicate<T>... predicates)
    {
        return Stream.of(predicates)
                .reduce(Predicate::or)
                .orElse(t->false);
    }

    @SafeVarargs
    private static <T> T firstAnyMatch(final Stream<T> streams, final Predicate<T>... predicates)
    {
        final Predicate<T> test = anyPassPredicate(predicates);
        return streams.filter(test)
                .findFirst()
                .orElse(null);
    }
}
