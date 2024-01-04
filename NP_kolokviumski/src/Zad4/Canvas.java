package Zad4;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Canvas implements Comparable<Canvas> {
    public String id;
    public List<Shape> shapes;

    public Canvas(String id, List<Shape> shapes) {
        this.id = id;
        this.shapes = shapes;
    }

    public static Canvas createCanvas(String line, int max_size) throws IrregularCanvasException {
        String []parts = line.split(" ");
        String id = parts[0];
        List<Shape> shape = new ArrayList<>();
        for (int i=1; i< parts.length; i+=2){
            Shape s = Shape.createShape(Integer.parseInt(parts[i+1]),parts[i].charAt(0));
            if(s.area() > max_size){
                throw new IrregularCanvasException(parts[0], max_size);
            }
            shape.add(s);
        }
        return new Canvas(id, shape);
    }
    public int getCircleCount(){
        return (int) shapes.stream().filter(shape -> shape.getType().equals(Type.CIRCLE)).count();
    }

    @Override
    public String toString() {
        DoubleSummaryStatistics dss = shapes.stream().mapToDouble(Shape::area).summaryStatistics();
        return String.format("%s %d %d %d %.2f %.2f %.2f", id, shapes.size(),getCircleCount(),shapes.size()-getCircleCount(), dss.getMin(), dss.getMax(), dss.getAverage());
    }

    @Override
    public int compareTo(Canvas o) {
        return Double.compare(this.shapes.stream().mapToDouble(Shape::area).sum(), o.shapes.stream().mapToDouble(Shape::area).sum());
    }
}
