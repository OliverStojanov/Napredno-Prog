package Zad17;

public class InvalidIDException extends Throwable {
    public InvalidIDException(String id) {
        super(String.format("ID %s is not valid", id));
    }
}
