package md.jack.task9;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercising
{
    //1
    private static List<Double> listGenerator(final long size)
    {
        return Stream.generate(() -> Math.random() * 1)
                .limit(size)
                .collect(Collectors.toList());
    }

    //2
    private static Double average(final List<Double> list)
    {
        return list.stream()
                .mapToDouble(it -> it)
                .average()
                .orElse(0.0);
    }

    //3
    private static void listCutoff(final List<Double> list, final double cutOff)
    {
        list.removeIf(it -> it < cutOff);
    }

    //5
    private static void listModifier(final List<Double> list)
    {
        list.replaceAll(it -> it * 2);
    }

    public static void main(String[] args)
    {
        //4
        List<Double> someList = listGenerator(1000);
        System.out.println(average(someList));
        listCutoff(someList, 0.5);
        System.out.println(average(someList));
        //6
        List<Double> testList = listGenerator(10000);
        System.out.println(average(testList));
        listModifier(testList);
        System.out.println(average(testList));


    }
}
