package md.jack.task8;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class TimingTests
{
    public static void main(String[] args)
    {
        IntStream.range(3, 8)
                .map(it -> (int) Math.pow(10, it))
                .peek(it -> System.out.printf("Sorting array of length %,d.%n", it))
                .forEach(it -> Op.timeOp(() -> sortArray(it)));
    }

    /** Make an n-length array of random numbers. */

    private static double[] randomNums(int length)
    {
        return DoubleStream.generate(Math::random)
                .limit(length)
                .toArray();
    }

    private static void sortArray(final int length)
    {
        final double[] nums = randomNums(length);
        Arrays.sort(nums);
    }
}