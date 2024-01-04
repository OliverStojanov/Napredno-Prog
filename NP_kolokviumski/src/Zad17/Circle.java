package Zad17;

public class Circle extends Shape{
    public double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double CalculateArea() {
        return Math.pow(radius,2) * Math.PI;
    }

    @Override
    public double CalculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void scale(double coef) {
        radius*=coef;
    }

    @Override
    public String toString() {
        return String.format("Circle -> Radius: %.2f Area: %.2f Perimeter: %.2f",radius,CalculateArea(), CalculatePerimeter());
    }
}
