package Zad50;

public class InvalidPositionException extends Exception{
    public InvalidPositionException(int position) {
        super(String.format("Invalid position %d, alredy taken!", position));
    }
}
