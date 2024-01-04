package Zad38;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Scheduler<T> {
    List<Timestamp<T>> elements;
    public Scheduler() {
        elements = new ArrayList<>();
    }

    public void add(Timestamp<T> stringTimestamp) {
        elements.add(stringTimestamp);
    }

    public Timestamp<T> next() {
        return elements.stream()
                .filter(element -> element.isAfterNow())
                .sorted()
                .findFirst()
                .orElse(null);
    }

    public Timestamp<T> last() {
        return elements.stream()
                .filter(element -> element.isBeforeNow())
                .sorted(Comparator.<Timestamp, LocalDateTime>comparing(Timestamp::getTime).reversed())
                .findFirst()
                .orElse(null);
    }

    public List<Timestamp<T>> getAll(LocalDateTime localDateTime, LocalDateTime localDateTime1) {
        return  elements.stream()
                .filter(element -> element.getTime().isAfter(localDateTime))
                .filter(element -> element.getTime().isBefore(localDateTime1))
                .collect(Collectors.toList());
    }

    public boolean remove(Timestamp<Integer> el) {
        if(elements.contains(el)){
            elements.remove(el);
            return true;
        }
        return false;
    }
}
