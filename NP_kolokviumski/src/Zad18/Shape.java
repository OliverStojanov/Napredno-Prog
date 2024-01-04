package Zad18;

public abstract class Shape implements Scalable,Stackable{
    public String id;
    public Color color;

    public Shape(String id, Color color) {
        this.id = id;
        this.color = color;
    }
}
