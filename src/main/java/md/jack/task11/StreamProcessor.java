package md.jack.task11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@FunctionalInterface
public interface StreamProcessor
{
    static void processFile(final String filename, final StreamProcessor processor)
    {
        try (Stream<String> lines = Files.lines(Paths.get(filename)))
        {
            processor.processStream(lines);
        }
        catch (IOException e)
        {
            System.err.println("Error reading file : " + e);
        }
    }

    void processStream(Stream<String> stringStream);

}
