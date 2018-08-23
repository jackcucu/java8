package md.jack.task8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import static md.jack.task8.MathUtils.randomArray;
import static md.jack.task8.MathUtils.randomGenerator;

public class Exercising
{
    public static void main(String[] args)
    {
        final double[] dubNum = randomArray(100);

        final double result = DoubleStream.of(dubNum)
                .map(Math::sqrt)
                .sum();
        System.out.println(result);

        final double result1 = DoubleStream.of(dubNum)
                .parallel()
                .map(Math::sqrt)
                .sum();
        System.out.println(result1);


        Op.timeOp(() -> {
            final double sum = MathUtils.sqrtSum(Arrays.stream(dubNum));
            System.out.printf("  Sum is %,.8f.%n", sum);
        });

        Op.timeOp(() -> {
            final double sum = MathUtils.sqrtSumParallel(Arrays.stream(dubNum));
            System.out.printf("  Sum is %,.8f.%n", sum);
        });

        System.out.println("Printing 5 random doubles : ");
        randomGenerator(10)
                .limit(5)
                .forEach(System.out::println);

        System.out.println("A List of 10 random doubles : ");
        final List<Double> list = randomGenerator(10)
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(list);

        System.out.println("An array of 20 random doubles : ");
        final Double[] array = randomGenerator(10)
                .limit(20)
                .toArray(Double[]::new);
        System.out.println(Arrays.asList(array));

    }

}
