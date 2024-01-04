package Zad16;

public class BonusNotAllowedException extends Throwable {
    public BonusNotAllowedException(String bonus){
        super(String.format("Bonus of %s is not allowed", bonus));
    }
}
