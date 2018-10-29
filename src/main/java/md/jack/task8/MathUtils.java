package md.jack.task8;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

class MathUtils
{

    static double[] randomArray(final long size)
    {
        return (new Random().doubles(size).toArray());
    }

    static double sqrtSum(final DoubleStream numStream)
    {
        return (numStream.map(Math::sqrt).sum());
    }

    static double sqrtSumParallel(final DoubleStream numStream)
    {
        return (numStream.parallel().map(Math::sqrt).sum());
    }

    static Stream<Double> randomGenerator(final double maxVal)
    {
        return Stream.generate(() -> Math.random() * maxVal);
    }

}