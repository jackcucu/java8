package md.jack.task11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@FunctionalInterface
public interface StreamAnalyzer<T>
{
    static <T> T analyzeFile(final String filename, final StreamAnalyzer<T> analyzer)
    {
        try (Stream<String> lines = Files.lines(Paths.get(filename)))
        {
            return analyzer.analyzeStream(lines);
        }
        catch (IOException e)
        {
            System.err.println("Error reading file: " + e);
            return null;
        }
    }

    T analyzeStream(Stream<String> stringStream);
}
