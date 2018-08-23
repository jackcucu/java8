package md.jack.task6;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Exercising {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hi", "ciao", "ola", "ceo", "hello", "salut", "pre", "quz");

        //1
        System.out.println("Words printed on separate line with 2 spaces in front:");
        words.stream()
                .forEach(it -> System.out.println("  "+it));
        //2
        System.out.println("Words printed on separte line with method reference");
        words.stream()
                .forEach(System.out::println);
        //3
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
        //4
        System.out.println("Different manipulation with strings:");
        words.stream()
                .filter(it -> it.length() < 4)
                .forEach(System.out::println);

        words.stream()
                .filter(it -> it.contains("b"))
                .forEach(System.out::println);

        words.stream()
                .filter(it -> (it.length() % 2) == 0)
                .forEach(System.out::println);
        //5
        System.out.println("Another manipulation: ");

        System.out.println(stringCheck(words, "E"));
        System.out.println(stringCheck(words, "Q"));

        //6
        System.out.println("Tracking how much time uppercasing is activated");
        final Function<String, String> check =
                it -> {
                    System.out.println("Uppercased");
                    return it.toUpperCase();
                };

        words.stream()
                .map(check)
                .filter(it -> it.length() < 4)
                .filter(it -> it.contains("E"))
                .findFirst()
                .orElse("No such words");
        //7
        System.out.println("Printing as array: ");
        String[] array = words.stream()
                .map(String::toUpperCase)
                .filter(it -> it.length() < 4)
                .filter(it -> it.contains("O"))
                .toArray(String[]::new);

        System.out.println(Arrays.toString(array));

    }

    private static String stringCheck(List<String> myList, String letter)
    {

        return myList.stream()
                .map(String::toUpperCase)
                .filter(it -> it.length() < 4)
                .filter(it -> it.contains(letter))
                .findFirst()
                .orElse("No such words");
    }

}
