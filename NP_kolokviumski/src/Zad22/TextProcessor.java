package Zad22;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.security.KeyStore;
import java.util.*;

public class TextProcessor {
    Map<String,Integer> mapCountWords;
    List<Map<String,Integer>> wordsByDocumentsMaps;
    List<String> rawTexts;
    public TextProcessor() {
        mapCountWords = new TreeMap<>();
        wordsByDocumentsMaps = new ArrayList<>();
        rawTexts = new ArrayList<>();
    }

    public void readText(InputStream in) {
        Scanner scanner = new Scanner(in);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            Map<String,Integer> mapCountW = new TreeMap<>();
            rawTexts.add(line);
            line = line.replaceAll("[^A-Za-z\\s+]","");
            line = line.toLowerCase();
            String []parts = line.split("\\s+");
            Arrays.stream(parts)
                    .forEach(part -> {
                        fillMap(mapCountW,part);
                        fillMap(mapCountWords,part);
                    });
            wordsByDocumentsMaps.add(mapCountW);
        }
        mapCountWords.keySet().forEach(word ->{
            wordsByDocumentsMaps.forEach(map -> map.putIfAbsent(word,0));
        });
    }
    public void fillMap(Map<String,Integer> map, String part){
        map.putIfAbsent(part,0);
        map.computeIfPresent(part,(k,v)->{
            v++;
            return v;
        });
    }

    public void printTextsVectors(PrintStream out) {
        PrintWriter printWriter = new PrintWriter(out);
        mapCountWords.values().stream().mapToInt(i -> i).forEach(printWriter::println);
        wordsByDocumentsMaps.stream().map(Map::values).forEach(printWriter::println);
        printWriter.flush();
    }

    public void printCorpus(PrintStream out, int i, boolean b) {
        PrintWriter printWriter = new PrintWriter(out);
        mapCountWords.entrySet().stream()
                .sorted(b ? Map.Entry.comparingByValue(Comparator.naturalOrder()): Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(i)
                .forEach(entry -> printWriter.println(String.format("%s : %d", entry.getKey(), entry.getValue())));
        printWriter.flush();
    }

    public void mostSimilarTexts(PrintStream out) {
        PrintWriter printWriter = new PrintWriter(out);
        double maxSimilarity = 0;
        int iMax = 0, jMax = 0;
        for(int i=0; i < rawTexts.size(); i++){
            for(int j = i+1; j < rawTexts.size(); j++){
                double sim = CosineSimilarityCalculator.cosineSimilarity(wordsByDocumentsMaps.get(i).values(),wordsByDocumentsMaps.get(j).values());
                if(maxSimilarity<sim){
                    maxSimilarity = sim;
                    iMax = i;
                    jMax = j;
                }
            }
        }

        printWriter.println(rawTexts.get(iMax));
        printWriter.println(rawTexts.get(jMax));
        printWriter.println(String.format("%.10f",maxSimilarity));

        printWriter.flush();
    }
}
