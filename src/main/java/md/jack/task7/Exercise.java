package md.jack.task7;

import java.util.Arrays;
import java.util.List;

public class Exercise
{
    public static void main(String[] args)
    {
        List<String> words = Arrays.asList("hi", "ciao", "ola", "ceo", "hello", "salut", "pre", "quz");
        //1
        final String concat = words.stream()
                .reduce("", (s1, s2) -> s2.toUpperCase() + s1);
        System.out.println("Concatenated words : " + concat);

        //2
        final String concat1 = words.stream()
                .map(String::toUpperCase)
                .reduce("", String::concat);
        System.out.println("Concatenated words : " + concat1);

        //3
        final String concat2 = words.stream()
                .reduce((s, s2) -> s + "," + s2)
                .orElse("Need 2 strings;");

        System.out.println("Concatenated with commas : " + concat2);

        //4
        final int numberOfChars = words.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("The number of chars is : " + numberOfChars);

        final long charsWithLetter = words.stream()
                .filter(it -> it.contains("h"))
                .count();
        System.out.println("Number of words containing 'h' : " + charsWithLetter);
    }

}
