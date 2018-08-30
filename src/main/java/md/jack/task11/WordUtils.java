package md.jack.task11;

import java.util.stream.Stream;

public final class WordUtils
{
    private WordUtils()
    {

    }

    public static void firstTen(final Stream<String> lines)
    {
        lines
                .filter(it -> it.length() == 10)
                .findFirst()
                .ifPresent(System.out::println);
    }

    public static void firstTen(final String filename)
    {
        StreamProcessor.processFile(filename, WordUtils::firstTen);
    }

    public static void firstN(final Stream<String> lines, final int length)
    {
        lines
                .filter(it -> it.length() == length)
                .findFirst()
                .ifPresent(System.out::println);
    }

    public static void firstN(final String filename, final int length)
    {
        StreamProcessor.processFile(filename, word -> firstN(word, length));
    }

    public static String nLetter(final Stream<String> lines, final int length)
    {
        return lines
                .filter(it -> it.length() == length)
                .findFirst()
                .orElse(null);
    }

    public static String nLetter(final String filename, final int length)
    {
        return StreamAnalyzer.analyzeFile(filename, word -> nLetter(word, length));
    }

    public static long wordCount(final Stream<String> lines, final String missing)
    {
        return lines
                .filter(it -> it.contains(missing))
                .count();
    }

    public static long wordCount(final String filename, final String missing)
    {
        return StreamAnalyzer.analyzeFile(filename, word -> wordCount(word, missing));
    }
}
