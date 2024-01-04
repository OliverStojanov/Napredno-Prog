package Zad52;

import java.util.*;
import java.util.stream.Collectors;

public class LabExercises {
    List<Student> students;

    public LabExercises() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void printByAveragePoints(boolean ascending, int i) {
        if(ascending){
            students.stream()
                    .sorted(Comparator.comparing(Student::average).thenComparing(Student::getIndex))
                    .limit(i)
                    .forEach(student -> System.out.println(student));
            return;
        }
        students.stream()
                .sorted(Comparator.comparing(Student::average).thenComparing(Student::getIndex).reversed())
                .limit(i)
                .forEach(student -> System.out.println(student));
    }

    public List<Student> failedStudents() {
        return students.stream()
                .filter(student -> !student.hasSignature())
                .sorted(Comparator.comparing(Student::getIndex).thenComparing(Student::average))
                .collect(Collectors.toList());
    }

    public Map<Integer, Double> getStatisticsByYear() {
        Map<Integer, Double> averageMap = new TreeMap<>();
        Map<Integer, Integer> countingMap = new TreeMap<>();

        students.stream()
                .filter(Student::hasSignature)
                .forEach(student -> {
                    Integer year = 20 - Integer.parseInt(student.getIndex().substring(0,2));
                    averageMap.putIfAbsent(year,0.0);
                    countingMap.putIfAbsent(year,0);

                    countingMap.computeIfPresent(year, (k,v) ->{
                        v++;
                        return v;
                    });

                    averageMap.computeIfPresent(year, (k,v)->{
                        v+= student.average();
                        return v;
                    });
                });
        for (Integer year:averageMap.keySet()) {
            averageMap.computeIfPresent(year, (k,v)->{
                v/=countingMap.get(year);
                return v;
            });
        }
        return averageMap;
    }
}
