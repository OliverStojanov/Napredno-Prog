package Zad20;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String id) {
        super(String.format("User with id %s already exists", id));
    }
}
