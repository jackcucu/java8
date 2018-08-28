package md.jack.task11;

import java.util.stream.Stream;

public class Exercising
{
    private static void useStream(Stream<String> lines)
    {
        lines
                .filter(it -> it.length() == 10)
                .findFirst()
                .ifPresent(System.out::println);
    }


    public static void main(String[] args)
    {

        final String filename = "enable1-word-list.txt";
        final Stream<String> stream = Stream.of("kuku", "iopta", "asdcvbhjkt", "doo");

        useStream(stream);
        StreamProcessor.processFile(filename, Exercising::useStream);

    }
}
