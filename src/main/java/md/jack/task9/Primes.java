package md.jack.task9;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A few utilities to generate a large random BigInteger,
 * and find the next prime number above a given BigInteger.
 * <p>
 * From <a href="http://courses.coreservlets.com/Course-Materials/">the
 * coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 * Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 * servlets, JSP, Java 8 lambdas and streams (for those that know Java already),
 * and Java 8 programming (for those new to Java)</a>.
 */

final public class Primes
{
    private static final BigInteger ZERO = BigInteger.ZERO;
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = new BigInteger("2");

    // Likelihood of false prime is less than 1/2^ERR_VAL.
    // Presumably BigInteger uses the Miller-Rabin test or
    // equivalent, and thus is NOT fooled by Carmichael numbers.
    // See Cormen et al.'s Introduction to Algorithms for details.
    private static final int ERR_VAL = 100;
    private static final String[] DIGITS =
            "0,1,2,3,4,5,6,7,8,9".split(",");
    private static final String[] NON_ZERO_DIGITS =
            "0,1,2,3,4,5,6,7,8,9".split(",");

    private Primes()
    {
    } // Uninstantiatable class

    public static boolean isPrime(final BigInteger possiblePrime)
    {
        return (possiblePrime.isProbablePrime(ERR_VAL));
    }

    public static boolean isPrime(final long possiblePrime)
    {
        return (isPrime(new BigInteger(Long.toString(possiblePrime))));
    }

    /** Finds the next prime number above a threshold. */

    private static BigInteger nextPrime(final BigInteger start)
    {
        final BigInteger zero = BigInteger.ZERO;

        final BigInteger integer = isEven(start)
                ? zero.add(start).add(ONE)
                : zero.add(start).add(TWO);

        return isPrime(integer) ? integer : nextPrime(integer);
    }

    /**
     * Generates a random number of the given length,
     * then finds the first prime number above that random number.
     */
    public static BigInteger findPrime(final int numDigits)
    {
        return numDigits < 1 ? nextPrime(randomNum(1)) : nextPrime(randomNum(numDigits));
    }

    private static boolean isEven(final BigInteger n)
    {
        return (n.mod(TWO).equals(ZERO));
    }

    private static String randomDigit(final boolean isZeroOk)
    {
        return isZeroOk ? RandomUtils.randomElement(DIGITS) : RandomUtils.randomElement(NON_ZERO_DIGITS);

    }

    /**
     * Creates a random big integer where every digit is
     * selected randomly (except that the first digit
     * cannot be a zero).
     */

    public static BigInteger randomNum(final int numDigits)
    {
        final String collect = IntStream.range(0, numDigits - 1)
                .mapToObj(it -> randomDigit(true))
                .collect(Collectors.joining("", randomDigit(false), ""));

        return new BigInteger(collect);
    }

    /**
     * Simple command-line program to test. Enter number
     * of digits, and the program picks a random number of that
     * length and then prints the first 50 prime numbers
     * above that.
     */


    public static void main(String[] args)
    {
        int numDigits;
        try
        {
            numDigits = Integer.parseInt(args[0]);
        }
        catch (Exception e)
        { // No args or illegal arg.
            numDigits = 2;
        }
        BigInteger currentPrime = randomNum(numDigits);

        for (int i = 0; i < 50; i++)
        {
            System.out.println(currentPrime);
            currentPrime = nextPrime(currentPrime);
        }

        Instant start = Instant.now();
        System.out.println(Utils.countPrimes1(5000));
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));

        Instant start1 = Instant.now();
        System.out.println(Utils.countPrime(1800));
        Instant end1 = Instant.now();
        System.out.println(Duration.between(start1, end1));

    }
}