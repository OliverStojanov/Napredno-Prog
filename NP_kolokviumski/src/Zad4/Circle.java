package Zad4;

public class Circle extends Shape {
    public Circle(int size) {
        super(size);
    }

    @Override
    public double area() {
        return Math.pow(size,2)* Math.PI;
    }

    @Override
    public Type getType() {
        return Type.CIRCLE;
    }
}
