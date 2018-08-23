package md.jack.task6;

import java.util.Arrays;
import java.util.List;

public class Exercising
{
    public static void main(String[] args)
    {
        List<String> words = Arrays.asList("hi", "ciao", "pre", "ola", "hello", "salut");

        System.out.println("Words printed on separate line with 2 spaces in front:");
        words.stream()
                .forEach(it -> System.out.println("  " + it));

        System.out.println("Words printed on separte line with method reference");
        words.stream()
                .forEach(System.out::println);

        System.out.println("Different manipulation with strings:");
        words.stream()
                .map(it -> it + "!")
                .forEach(System.out::println);

        words.stream()
                .map(it -> it.replace("i", "eye"))
                .forEach(System.out::println);

        words.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        words.stream()
                .filter(it -> it.length() < 4)
                .forEach(System.out::println);

        words.stream()
                .filter(it -> it.contains("b"))
                .forEach(System.out::println);

        words.stream()
                .filter(it -> (it.length() % 2) == 0)
                .forEach(System.out::println);

        System.out.println("Another manipulation: ");
        words.stream()
                .map(String::toUpperCase)
                .filter(it -> it.length() < 4)
                .filter(it -> it.contains("E"))
                .findFirst()
                .ifPresent(System.out::println);

        words.stream()
                .map(String::toUpperCase)
                .allMatch(it -> it.length() <4);

    }

}
