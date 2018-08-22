package md.jack.task1;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringUtils
{
    private StringUtils()
    {
    } // Uninstantiatable class; contains only static methods.

    public static String betterString(String s1, String s2,
                                      TwoStringPredicate tester)
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

    public static List<String> allMatches(List<String> theList, Predicate<String> condition)
    {
        return  theList.stream()
                .filter(condition::test)
                .collect(Collectors.toList());
    }

    public static  List<String> transformedList(List<String> theList, Function<String,String> function)
    {
        return  theList.stream()
                .map(function::apply)
                .collect(Collectors.toList());
    }
}
