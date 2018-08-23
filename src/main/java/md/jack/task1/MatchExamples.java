package md.jack.task1;

import java.util.stream.Stream;

public class MatchExamples
{
    public static void main(final String[] args)
    {
        final String[] test1 = {"a", "b", "   "};
        System.out.println("isAnyMissing(test1): " + isAnyMissing(test1));

        final String[] test2 = {"a", "b", null};
        System.out.println("isAnyMissing(test2): " + isAnyMissing(test2));

        final String[] test3 = {"a", "b", "c"};
        System.out.println("isAnyMissing(test3): " + isAnyMissing(test3));

        System.out.println("isAnyMissing2(test1): " + isAnyMissing2(test1));
        System.out.println("isAnyMissing2(test2): " + isAnyMissing2(test2));
        System.out.println("isAnyMissing2(test3): " + isAnyMissing2(test3));
    }

    private static boolean isMissing(final String value)
    {
        return ((value == null) || (value.trim().isEmpty()));
    }

    private static boolean isAnyMissing(final String... values)
    {
        return (Stream.of(values).anyMatch(s -> isMissing(s)));
    }

    private static boolean isAnyMissing2(final String... values)
    {
        return (Stream.of(values).anyMatch(MatchExamples::isMissing));
    }
}
