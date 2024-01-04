package Zad4;

public class Square extends Shape {
    public Square(int size) {
        super(size);
    }

    @Override
    public double area() {
        return Math.pow(size,2);
    }

    @Override
    public Type getType() {
        return Type.SQUERE;
    }
}
