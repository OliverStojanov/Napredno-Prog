package Zad7;

import java.time.LocalDateTime;
import java.util.Comparator;

public class File implements Comparable<File> {
    public String name;
    public int size;
    public LocalDateTime createdAt;

    public File(String name, int size, LocalDateTime localDateTime) {
        this.name = name;
        this.size = size;
        this.createdAt = localDateTime;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public boolean isHidden(){
        return name.startsWith(".");
    }

    public String toMonthDay(){
        return String.format("%s-%s",createdAt.getMonth(),createdAt.getDayOfMonth());
    }

    @Override
    public int compareTo(File o) {
        return Comparator.comparing(File::getCreatedAt)
                .thenComparing(File::getName)
                .thenComparing(File::getSize)
                .compare(this,o);
    }

    @Override
    public String toString() {
        return String.format("%-10s %5dB %s",name, size, createdAt);
    }
}
