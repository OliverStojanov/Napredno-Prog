package Zad36;

public class Point2D implements Clusterable<Point2D> {

    long id;
    float x;
    float y;

    public Point2D(long id, float x, float y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    @Override
    public long id() {
        return id;
    }

    @Override
    public double distance(Point2D point) {
        return Math.sqrt((x - point.x)*(x - point.x)+(this.y - point.y)*(this.y - point.y));
    }
}