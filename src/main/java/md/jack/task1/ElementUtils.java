package md.jack.task1;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Method that uses the generic TwoElementPredicate, rather than the
 * String-specific TwoStringPredicate.
 * <p>
 * From <a href="http://courses.coreservlets.com/Course-Materials/">the
 * coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 * Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 * servlets, JSP, Java 8 lambdas and streams (for those that know Java already),
 * and Java 8 programming (for those new to Java)</a>.
 */

public class ElementUtils
{
    private ElementUtils()
    {
    } // Uninstantiatable class; contains only static methods.

    public static <T> T betterElement(T element1, T element2,
                                      TwoElementPredicate<T> tester)
    {
        if (tester.isBetter(element1, element2))
        {
            return (element1);
        }
        return (element2);
    }

    public static <T> List<T> allMatches(List<T> theList, Predicate<T> condition)
    {
        return  theList.stream()
                .filter(condition::test)
                .collect(Collectors.toList());
    }

    public static <T,R> List<R> transformedList(List<T> theList, Function<T,R> function)
    {
        return  theList.stream()
                .map(function::apply)
                .collect(Collectors.toList());
    }
}
