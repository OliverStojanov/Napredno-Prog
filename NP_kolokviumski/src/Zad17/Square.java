package Zad17;

public class Square extends Shape{
    public double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double CalculateArea() {
        return Math.pow(side,2);
    }

    @Override
    public double CalculatePerimeter() {
        return side * 4;
    }

    @Override
    public void scale(double coef) {
        side*=coef;
    }

    @Override
    public String toString() {
        return String.format("Square -> Side: %.2f Area: %.2f Perimeter: %.2f",side,CalculateArea(), CalculatePerimeter());
    }
}
