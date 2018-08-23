package md.jack.task2;

public class IsBetterExamples
{
    public static void main(final String[] args)
    {
        final String test1 = "Hello";

        final String test2 = "Goodbye";

        final String message = "Better of %s and %s based on %s is %s.%n";

        final String result1 = StringUtils.betterString(test1, test2, (s1, s2) -> s1.length() > s2.length());
        System.out.printf(message, test1, test2, "length", result1);

        final String result2 = StringUtils.betterString(test1, test2, (s1, s2) -> true);
        System.out.printf(message, test1, test2, "1st arg", result2);

        final String result3 = ElementUtils.betterElement(test1, test2, (s1, s2) -> s1.length() > s2.length());
        System.out.printf(message, test1, test2, "length", result3);

        final String result4 = ElementUtils.betterElement(test1, test2, (s1, s2) -> true);
        System.out.printf(message, test1, test2, "1st arg", result4);

        final int result5 = ElementUtils.betterElement(1, 2, (n1, n2) -> n1 > n2);
        System.out.printf(message, 1, 2, "numeric size", result5);
    }
}
