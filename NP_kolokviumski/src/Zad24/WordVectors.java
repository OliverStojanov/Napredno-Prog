package Zad24;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WordVectors {
    Map<String,Vector> vectorsMap;
    List<Vector> vectors;

    public WordVectors(String[] words, List<List<Integer>> vectors) {
        this.vectorsMap = new TreeMap<>();
        IntStream.range(0, words.length)
                .forEach(i -> this.vectorsMap.put(words[i],new Vector(vectors.get(i))));
    }

    public void readWords(List<String> wordsList) {
        vectors = wordsList.stream().map(word ->
                vectorsMap.getOrDefault(word, Vector.DEFAULT)
        ).collect(Collectors.toList());
    }

    public List<Integer> slidingWindow(int n) {
        return  IntStream.range(0, vectors.size() - n+1)
                .mapToObj(i ->
                    vectors.subList(i,i+n).stream()
                            .reduce(Vector.IDENTITY,Vector::sum)
                ).map(Vector::max)
                .collect(Collectors.toList());
    }
}
