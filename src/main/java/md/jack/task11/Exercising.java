package md.jack.task11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Exercising
{

    public static void main(String[] args)
    {

        final String filename = "enable1-word-list.txt";
        final List<String> list = Arrays.asList("kuku", "iopta", "asdcvbhjkt", "d", "doo", "asdgfhvcsde", "asdcvb", "qwervbn", "qwervbnm");

        //1
        System.out.println("First 10-letter word from stream : ");
        WordUtils.firstTen(list.stream());

        System.out.println("First 10-letter word from file : ");
        WordUtils.firstTen(filename);


        //2
        System.out.println("First n-length word from stream :");
        WordUtils.firstN(list.stream(), 11);

        System.out.println("First n-length word from file : ");
        WordUtils.firstN(filename, 11);

        //3
        System.out.println("First 1-11 length word from stream :");
        IntStream.range(1, 11)
                .forEach(it -> System.out.println(it + "-length number:" + WordUtils.nLetter(list.stream(), it)));
        System.out.println("First 1-11 length word from file :");
        IntStream.range(1, 11)
                .forEach(it -> System.out.println(it + "-length number:" + WordUtils.nLetter(filename, it)));

        //4
        System.out.println("Words containing a from stream : ");
        System.out.println(WordUtils.wordCount(list.stream(), "a"));

        System.out.println("Words containing g from file : ");
        System.out.println(WordUtils.wordCount(filename, "g"));

        System.out.println(WordUtils.wordCount(filename, "x") > WordUtils.wordCount(filename, "j")
                ? "There are more words containing x"
                : "There are more words containing j");

        System.out.println(WordUtils.wordCount(filename, "ee") > WordUtils.wordCount(filename, "oo")
                ? "There are more words containing ee"
                : "There are more words containing oo");

    }
}
