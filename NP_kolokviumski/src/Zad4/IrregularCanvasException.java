package Zad4;

public class IrregularCanvasException extends Throwable {
    public IrregularCanvasException(String id, double Max_Size) {
        super(String.format("Canvas %s has a shape with area larger than %.2f", id, Max_Size));
    }
}
