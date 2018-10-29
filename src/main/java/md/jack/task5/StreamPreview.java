package md.jack.task5;

import java.util.Arrays;
import java.util.List;

public class StreamPreview
{
    public static void main(String[] args)
    {
        List<String> words = Arrays.asList("hi", "hello", "bye", "goodbye");

        System.out.println(FunctionUtils.firstAllMatch(words.stream(),
                it -> it.contains("o"),
                it -> it.length() > 5));

        System.out.println(FunctionUtils.firstAnyMatch(words.stream(),
                it -> it.contains("o"),
                it -> it.length() > 5));
    }
}