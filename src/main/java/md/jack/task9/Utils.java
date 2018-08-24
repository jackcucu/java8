package md.jack.task9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Utils
{
    private final static Map<Integer, Integer> primes = new HashMap<>();

    public static int countPrimes1(int upperBound)
    {
        if (upperBound <= 2)
        {
            return (1);
        }
        if (Primes.isPrime(upperBound))
        {
            return (1 + countPrimes1(upperBound - 1));
        }
        else
        {
            return (countPrimes1(upperBound - 1));
        }
    }

    public static int countPrime(int upperBound)
    {
        return (primes.computeIfAbsent(upperBound, Utils::apply));
    }

    private static List<Double> randomList(int size)
    {
        final List<Double> nums = new ArrayList<>(size);
        Stream.of(nums).forEach(it -> it.add(Math.random()));
        return nums;
    }

    private static int apply(Integer it)
    {
        if (it <= 2)
        {
            return (1);
        }
        if (Primes.isPrime(it))
        {
            return (1 + countPrime(it - 1));
        }
        else
        {
            return (countPrime(it - 1));
        }
    }
}
