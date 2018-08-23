package md.jack.task1;

/**
 * Method that uses the generic TwoElementPredicate, rather than the
 * String-specific TwoStringPredicate.
 */

public final class ElementUtils
{
    private ElementUtils()
    {
    }

    public static <T> T betterElement(final T element1, final T element2, final TwoElementPredicate<T> tester)
    {
        if (tester.isBetter(element1, element2))
        {
            return (element1);
        }
        return (element2);
    }
}
