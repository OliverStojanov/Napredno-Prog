package Zad17;

public class InvalidDimesionException extends Throwable {
    public InvalidDimesionException(Double side1) {
        super(String.format("Dimensions %.2f is not allowed", side1));
    }
}
