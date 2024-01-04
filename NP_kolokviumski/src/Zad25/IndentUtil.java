package Zad25;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IndentUtil {

    public static String createIndent (int indent){
        return IntStream.range(0,indent)
                .mapToObj(i -> "\t")
                .collect(Collectors.joining());
    }

}
