package md.jack.task2;

public final class StringUtils
{
    private StringUtils()
    {
    }

    public static int eChecker(final String s1, final String s2)
    {
        int compareFlag = 0;
        if (s1.contains("e") && !s2.contains("e"))
        {
            compareFlag = -1;
        }
        else if (s2.contains("e") && !s1.contains("e"))
        {
            compareFlag = 1;
        }
        return (compareFlag);
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
