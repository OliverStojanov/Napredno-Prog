package Zad30;

public class InvalidArchiveOpenException extends Exception {
    public InvalidArchiveOpenException(String format) {
        super(format);
    }
}
