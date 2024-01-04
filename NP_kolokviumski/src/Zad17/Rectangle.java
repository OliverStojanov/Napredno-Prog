package Zad17;

public class Rectangle extends Shape{
    public double side1;
    public double side2;

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double CalculateArea() {
        return side1*side2;
    }

    @Override
    public double CalculatePerimeter() {
        return side1*2+side2*2;
    }

    @Override
    public void scale(double coef) {
        side2*=coef;
        side1*=coef;
    }
    @Override
    public String toString() {
        return String.format("Rectangle -> Sides: %.2f %.2f Area: %.2f Perimeter: %.2f",side1, side2, CalculateArea(), CalculatePerimeter());
    }

}
