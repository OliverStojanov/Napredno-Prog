package Zad38;

import java.time.LocalDateTime;
import java.util.Objects;

public class Timestamp<T> implements Comparable<Timestamp <? extends T>>{
    LocalDateTime time;
    T element;
    public Timestamp(LocalDateTime time, T element) {
        this.time = time;
        this.element = element;
    }

    public LocalDateTime getTime() {
        return  time;
    }
    public boolean isAfterNow(){
        return time.isAfter(LocalDateTime.now());
    }

    public boolean isBeforeNow(){
        return time.isBefore(LocalDateTime.now());
    }

    public T getElement() {
        return  element;
    }

    @Override
    public int compareTo(Timestamp<? extends T> o) {
        return time.compareTo(o.time);
    }

    @Override
    public boolean equals(Object o) {
        Timestamp<T> t = (Timestamp<T>) o;
        return this.time.equals(t.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, element);
    }

    @Override
    public String toString() {
        return time + " " + element;
    }

}
