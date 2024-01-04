package Zad7;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class FileSystem {
    Map<Character, Set<File>> files;
    Comparator<File> fileComparator = Comparator.comparing(File::getCreatedAt)
            .thenComparing(File::getName)
            .thenComparing(File::getSize);
    public FileSystem() {
        files = new HashMap<>();
    }

    public void addFile(char folder, String name, int size, LocalDateTime createdAt) {
        Set<File> computed = files.computeIfAbsent(folder, key -> new TreeSet<>(fileComparator));
        computed.add(new File(name,size,createdAt));
    }

    public List<File> findAllHiddenFilesWithSizeLessThen(int size) {
        return files.values().stream()
                .flatMap(Collection::stream)
                .filter(file -> file.isHidden())
                .filter(file -> file.getSize() < size)
                .collect(Collectors.toList());
    }

    public int totalSizeOfFilesFromFolders(List<Character> collect) {
        return collect.stream().mapToInt(folder -> files.get(folder).stream().mapToInt(File::getSize).sum()).sum();
    }

    public Map<Integer, Set<File>> byYear() {
        return files.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(file -> file.getCreatedAt().getYear(), Collectors.toSet()));
    }

    public Map<String, Long> sizeByMonthAndDay() {
        return  files.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(File::toMonthDay, Collectors.summingLong(File::getSize)));
    }
}
