package md.jack.task6;

import java.util.Arrays;
import java.util.List;

public class Exercising
{
    public static void main(String[] args)
    {
        List<String> words = Arrays.asList("hi", "ciao", "ola", "hello", "salut", "hey");

        System.out.println("Words printed on separate line with 2 spaces in front:");
        words.stream()
                .forEach(it -> System.out.println("  " + it));

        System.out.println("Words printed on separte line with method reference");
        words.stream()
                .forEach(System.out::println);

        System.out.println("Different manipulation with strings:");
        words.stream()
                .map(it -> it.length() < 4)
                .forEach(System.out::print);

        words.stream()
                .map(it -> it.replace("i", "eye"))
                .forEach(System.out::print);

        words.stream()
                .map(String::toUpperCase)
                .forEach(System.out::print);

    }

}
