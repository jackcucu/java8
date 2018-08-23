package md.jack.task1;

public final class StringUtils
{
    private StringUtils()
    {
    }

    public static String betterString(final String s1, final String s2, final TwoStringPredicate tester)
    {
        if (tester.isBetter(s1, s2))
        {
            return (s1);
        }
        else
        {
            return (s2);
        }
    }
}
