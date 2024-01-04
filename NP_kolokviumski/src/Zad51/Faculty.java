package Zad51;

import java.util.Arrays;
import java.util.Comparator;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Faculty {
    String name;
    Student[] students;
    public Faculty(String name, Student[] students) {
        this.name = name;
        this.students = Arrays.copyOf(students,students.length);
    }

    public Student getStudent(long index) {
        return Arrays.stream(students)
                .filter(student -> student.getIndex() == index)
                .findFirst()
                .orElse(null);
    }
    public int countStudentsFromCity(String cityName){
        return (int) Arrays.stream(students)
                .filter(student ->student.getCity().equals(cityName))
                .count();
    }
    public double getAverageNumberOfContacts(){
        return Arrays.stream(students)
                .mapToInt(student -> student.contacts.length)
                .average()
                .orElse(0.0);
    }
    public Student getStudentWithMostContacts() {
        return Arrays.stream(students)
                .sorted(Comparator.comparing(Student::getContactsLength).reversed()
                        .thenComparing(Comparator.comparing(Student::getIndex).reversed()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ","{","}");
        stringJoiner.add(String.format("\"%s\":\"%s\"", "fakultet", name));
        String studentsFilter = Arrays.stream(students)
                .map(Student::toString)
                .collect(Collectors.joining(", ", "[","]"));
        stringJoiner.add(String.format("\"%s\":%s", "studenti", studentsFilter));
        return stringJoiner.toString();
    }
}
