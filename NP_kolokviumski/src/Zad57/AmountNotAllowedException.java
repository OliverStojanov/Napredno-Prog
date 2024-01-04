package Zad57;

public class AmountNotAllowedException extends Exception{
    public AmountNotAllowedException(int sum) {
        super(String.format("Receipt with amount %d is not allowed to be scanned",sum));
    }
}
