package md.jack.task9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Utils
{
    private Utils()
    {

    }

    private final static Map<Integer, Integer> primes = new HashMap<>();

    public static int countPrimes1(final int upperBound)
    {
        if (upperBound <= 2)
        {
            return (1);
        }

        return Primes.isPrime(upperBound)
                ? 1 + countPrimes1(upperBound - 1)
                : countPrimes1(upperBound - 1);

    }

    public static int countPrime(final int upperBound)
    {
        return (primes.computeIfAbsent(upperBound, Utils::apply));
    }

    public static List<Double> randomList(int size)
    {

        return Stream.generate(Math::random)
                .limit(size)
                .collect(Collectors.toList());

    }

    private static int apply(final Integer it)
    {
        if (it <= 2)
        {
            return (1);
        }

        return Primes.isPrime(it) ? 1 + countPrime(it - 1) : countPrime(it - 1);

    }
}
