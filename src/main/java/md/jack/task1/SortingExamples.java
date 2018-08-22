package md.jack.task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class SortingExamples
{
  public static void main(String[] args)
  {
    String[] words = {"hi", "hello", "hola", "bye", "goodbye", "adios"};

    System.out.println("Original array: " +
            Arrays.asList(words));

    Arrays.sort(words, Comparator.comparingInt(String::length));
    System.out.println("Sorted by length ascending: " +
            Arrays.asList(words));

    Arrays.sort(words, Comparator.comparingInt(String::length).reversed());
    System.out.println("Sorted by length descending : " +
            Arrays.asList(words));

    Arrays.sort(words, Comparator.comparingInt(s -> s.charAt(0)));
    System.out.println("Sorted by first letter : " +
            Arrays.asList(words));

    Arrays.sort(words, (s1, s2) ->
    {
      int compareFlag = 0;
      if (s1.contains("e") && !s2.contains("e"))
      {
        compareFlag = -1;
      }
      else if (s2.contains("e") && !s1.contains("e"))
      {
        compareFlag = 1;
      }
      return (compareFlag);
    });
    System.out.println("Sorted by whether it contains 'e' [v1] : " +
            Arrays.asList(words));

    List<String> words1 = Arrays.asList("ciao", "ola", "hi", "hello", "goodbye", "zdarowa");
    System.out.println("Original array: " +
            words1);

    List<String> shortWords = StringUtils.allMatches(words1,s -> s.length() < 4);
    System.out.println("Sorted by short words : " +
            shortWords);

    List<String> wordsWithB = StringUtils.allMatches(words1,s -> s.contains("b"));
    System.out.println("Words that contains b : " +
            wordsWithB);

    List<String> evenLengthWords = StringUtils.allMatches(words1,s -> (s.length() % 2 == 0));
    System.out.println("Even length words : " +
            evenLengthWords);

    List<Integer> nums = Arrays.asList(1, 10, 100, 1000, 10000);
    System.out.println("Original array: " +
            nums);

    List<Integer> bigNums = ElementUtils.allMatches(nums, n -> n > 500);
    System.out.println("Sorted list of integers : " +
            bigNums);

    List<String> excitingWords = StringUtils.transformedList(words1, s -> s + "!");
    System.out.println("Exciting words : " +
            excitingWords);

    List<String> eyeWords = StringUtils.transformedList(words1, s -> s.replace("i","eye"));
    System.out.println("Replaced i with eye : " +
            eyeWords);

    List<String> upperCaseWords = StringUtils.transformedList(words1, String::toUpperCase);
    System.out.println("Uppercase words : " +
            upperCaseWords);

    List<Integer> wordLengths = ElementUtils.transformedList(words1, String::length);
    System.out.println("Returning a list of words length : " +
            wordLengths);

  }
}
