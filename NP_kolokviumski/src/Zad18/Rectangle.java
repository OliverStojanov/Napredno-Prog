package Zad18;

public class Rectangle extends Shape{
    public float width, height;

    public Rectangle(String id, Color color, float width, float height) {
        super(id, color);
        this.height = height;
        this.width = width;
    }

    @Override
    public void scale(float scaleFactor) {
        width*=scaleFactor;
        height*=scaleFactor;
    }

    @Override
    public float weight() {
        return width*height;
    }

    @Override
    public String toString() {
        return String.format("R: %-5s%-10s%10.2f\n",id, color, weight());
    }
}
