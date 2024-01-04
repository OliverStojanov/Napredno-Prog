package Zad63;

public class EmptyOrder extends Exception {
    public EmptyOrder() {
        super("The order must not be empty");
    }
}
