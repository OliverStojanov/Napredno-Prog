package Zad8;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class GenericCollection<T extends Comparable<T> & IHasTimestamp> {

    public Map<String, Set<T>> genericCollections;

    public GenericCollection() {
        genericCollections = new HashMap<>();
    }

    public void addGenericItem(String category, T integerElement) {
        genericCollections.putIfAbsent(category,new TreeSet<>());
        genericCollections.computeIfPresent(category, (k,v) -> {
            v.add(integerElement);
            return v;
        });
    }

    public Collection<T> itemsFromCategories(List<String> categories) {
        return genericCollections.keySet().stream()
                .filter(categories::contains)
                .flatMap(category -> genericCollections.get(category).stream())
                .collect(Collectors.toCollection(() -> new TreeSet<T>(Comparator.reverseOrder())));

    }

    public Collection<T> findAllBetween(LocalDateTime start, LocalDateTime end) {
        return genericCollections.values().stream()
                .flatMap(Collection::stream)
                .filter(time -> time.getTimestamp().isAfter(start)&&time.getTimestamp().isBefore(end))
                .collect(Collectors.toCollection(() -> new TreeSet<T>(Comparator.reverseOrder())));
    }

    public Map<String, Set<T>> byMonthAndDay() {
        return genericCollections.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(
                        element -> String.format("%02d-%02d",element.getTimestamp().getMonthValue(), element.getTimestamp().getDayOfMonth()),
                        TreeMap::new,
                        Collectors.toCollection(() -> new TreeSet<T>(Comparator.reverseOrder()))
                ));
    }

    public Map<Integer, Long> countByYear() {
        return genericCollections.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(
                   element -> element.getTimestamp().getYear(),
                        TreeMap::new,
                        Collectors.counting()
                ));
    }
}
