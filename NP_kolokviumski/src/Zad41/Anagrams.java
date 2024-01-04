package Zad41;

import java.io.InputStream;
import java.util.*;

public class Anagrams {

    public static void main(String[] args) {
        findAll(System.in);
    }

    public static void findAll(InputStream inputStream) {
        // Vasiod kod ovde
        Map<String,Set<String>> anagrams = new TreeMap<>();
        ArrayList<String> allWords = new ArrayList<>();
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNextLine()){
            String word = scanner.nextLine();
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);
            if(anagrams.containsKey(key)){
                Set<String> set = anagrams.get(key);
                set.add(word);
            }else{
                allWords.add(key);
                Set<String> set = new TreeSet<>();
                set.add(word);
                anagrams.put(key,set);
            }
        }
        scanner.close();
        ListIterator<String> it = allWords.listIterator();
        while (it.hasNext()){
            Set<String> set =anagrams.get(it.next());
            if(set.size()>=5){
                Iterator<String> iterator = set.iterator();
                while (iterator.hasNext()){
                    System.out.print(iterator.next());
                    if(iterator.hasNext()){
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
