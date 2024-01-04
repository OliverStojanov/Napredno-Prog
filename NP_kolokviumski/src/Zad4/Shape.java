package Zad4;

public abstract class Shape {
    int size;

    public Shape(int size) {
        this.size = size;
    }
    public abstract double area();
    public abstract Type getType();

    public static Shape createShape(int size, char type){
        switch (type){
            case 'C': return new Circle(size);
            case 'S': return new Square(size);
            default: return null;
        }
    }
}
