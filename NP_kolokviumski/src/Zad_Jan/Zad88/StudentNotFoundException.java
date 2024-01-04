package Zad_Jan.Zad88;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String id) {
        super(String.format("Student %s not found!",id));
    }
}
