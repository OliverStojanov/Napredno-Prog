package Zad18;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
    List<Shape> shapes;

    public Canvas() {
        this.shapes = new ArrayList<>();
    }

    public int find(float weight){
        for(int i=0; i<shapes.size(); i++){
            if(shapes.get(i).weight() < weight){
                return i;
            }
        }
        return  shapes.size();
    }

    public void add(String id, Color color, float radius) {
        Circle circle = new Circle(id,color,radius);
        int index = find(circle.weight());
        shapes.add(index,circle);
    }

    public void add(String id, Color color, float width, float height) {
        Rectangle rectangle = new Rectangle(id,color,width,height);
        int index = find(rectangle.weight());
        shapes.add(index,rectangle);
    }

    public void scale(String id, float scaleFactor) {
        Shape s = null;
        for(int i=0; i<shapes.size(); i++){
            if (shapes.get(i).id.equals(id)){
                s = shapes.get(i);
                shapes.remove(i);
                break;
            }
        }
        s.scale(scaleFactor);
        int index = find(s.weight());
        shapes.add(index,s);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Shape shape: shapes) {
            sb.append(shape);
        }
        return sb.toString();
    }
}
