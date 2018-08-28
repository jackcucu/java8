package md.jack.task10;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercising
{
    //1
    private static String firstTenWords(final String fileName) throws IOException
    {
        final String errorMsg = "No such word";
        return Files.lines(Paths.get(fileName))
                .filter(it -> it.length() == 10)
                .findFirst()
                .orElse(errorMsg);
    }

    //2
    private static String firstEightWords(final String fileName) throws IOException
    {
        final String errorMsg = "No such word.";
        return Files.lines(Paths.get(fileName))
                .filter(it -> it.length() == 8)
                .filter(it -> it.contains("a"))
                .filter(it -> it.contains("b"))
                .filter(it -> it.contains("c"))
                .findFirst()
                .orElse(errorMsg);

    }

    //3
    private static String mixedCase(final String filename) throws IOException
    {
        final String errorMsg = "No such word";
        return Files.lines(Paths.get(filename))
                .filter(it -> it.length() == 8)
                .map(String::toLowerCase)
                .filter(it -> it.contains("a"))
                .filter(it -> it.contains("b"))
                .filter(it -> it.contains("c"))
                .findFirst()
                .orElse(errorMsg);
    }

    //4
    private static String longestWord(final String filename) throws IOException
    {
        final String errorMsg = "No such word";
        return Files.lines(Paths.get(filename))
                .filter(it -> !it.contains("a"))
                .filter(it -> !it.contains("e"))
                .max(Comparator.comparing(String::length))
                .orElse(errorMsg);
    }

    //5
    private static String shortersWord(final String filename) throws IOException
    {
        final String errorMsg = "No such word";
        return Files.lines(Paths.get(filename))
                .filter(it -> it.contains("q"))
                .min(Comparator.comparing(String::length))
                .orElse(errorMsg);
    }

    //6
    private static Path writeFile(final String filename1, final String filename2) throws IOException
    {
        final List<String> lines = Files.lines(Paths.get(filename1))
                .filter(it -> it.contains("wow") || it.contains("cool"))
                .map(it -> it.toUpperCase() + "!")
                .collect(Collectors.toList());

        return Files.write(Paths.get(filename2), lines, Charset.defaultCharset());
    }

    //7
    private static long numberOfFolders(final String folder) throws IOException
    {
        return Files.list(Paths.get(folder))
                .count();
    }

    //8
    private static void writeFileDoubles(final String filename)
    {
        final List<Double> doubles = Stream.generate(() -> Math.random() * 100)
                .limit(17)
                .collect(Collectors.toList());

        try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(Paths.get(filename), Charset.defaultCharset())))
        {
            doubles.forEach(it -> out.printf("Number %5.3f%n", it));

        }
        catch (IOException ioe)
        {
            System.out.printf("IOException : %s,%n", ioe);
        }
    }

    public static void main(String[] args) throws Exception
    {

        final String inputFile = "enable1-word-list.txt";
        final String outputFile = "twitter-words.txt";
        final String outputFile1 = "random-nums.txt";

        System.out.println("First 10-letter word : " + firstTenWords(inputFile));

        System.out.println("First 8-letter word that contains a,b,c : " + firstEightWords(inputFile));

        System.out.println("First 8-letter word for mixed case example : " + mixedCase(inputFile));

        System.out.println("Longest English word that contains neither a or e : " + longestWord(inputFile));

        System.out.println("Shortest English word that contains q : " + shortersWord(inputFile));

        System.out.println("Created a new file from enable1-word-list .");
        writeFile(inputFile, outputFile);

        System.out.println("Number of files : " + numberOfFolders("/"));

        System.out.println("Created a file with doubles .");
        writeFileDoubles(outputFile1);

    }
}