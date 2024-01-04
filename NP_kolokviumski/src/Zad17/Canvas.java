package Zad17;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;

public class Canvas {
    Set<Shape> allShapes;
    Map<String, Set<Shape>> shapes;

    public Canvas() {
        allShapes = new TreeSet<>(Comparator.comparing(Shape::CalculateArea));
        shapes = new TreeMap<>();
    }

    public void readShapes(InputStream in) throws InvalidDimesionException {
        Scanner scanner = new Scanner(in);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            try {
                String id = getID(line);
                Shape shape = createShape(line);
                shapes.putIfAbsent(id, new TreeSet<>(Comparator.comparing(Shape::CalculatePerimeter)));
                shapes.get(id).add(shape);
                allShapes.add(shape);

            }catch (InvalidIDException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public String getID(String line) throws InvalidIDException {
        String []parts = line.split("\\s+");
        String id = parts[1];
        if(parts[1].length() != 6){
            throw new InvalidIDException(id);
        }
        for (char c : id.toCharArray()) {
            if(!Character.isLetterOrDigit(c)){
                throw new InvalidIDException(id);
            }
        }
        return id;
    }
    public Shape createShape(String line) throws InvalidDimesionException {
        String []parts = line.split("\\s+");
        Double side1 = Double.parseDouble(parts[2]);
        if(side1 == 0){
            throw new InvalidDimesionException(side1);
        }else {
            Double type = Double.parseDouble(parts[0]);
            if(type == 1){
                return new Circle(side1);
            } else if (type == 2) {
                return new Square(side1);
            }else {
                Double side2 = Double.parseDouble(parts[3]);
                if (side2 == 0){
                    throw  new InvalidDimesionException(side2);
                }else {
                    return new Rectangle(side1,side2);
                }
            }
        }
    }

    public void printAllShapes(PrintStream out) {
        PrintWriter printWriter = new PrintWriter(out);
        allShapes.forEach(printWriter::println);
        printWriter.flush();
    }

    public void scaleShapes(String s, double v) {
        shapes.getOrDefault(s,new HashSet<>()).forEach(shape -> shape.scale(v));
    }

    public void printByUserId(PrintStream out) {
        PrintWriter printWriter = new PrintWriter(out);
        Comparator<Map.Entry<String,Set<Shape>>> entryComparator = Comparator.comparing(entry -> entry.getValue().size());

        shapes.entrySet().stream()
                .sorted(entryComparator.reversed().thenComparing(shape -> shape.getValue().stream().mapToDouble(Shape::CalculateArea).sum()))
                .forEach(entry ->{
                    printWriter.println("Shapes of user: " + entry.getKey());
                    entry.getValue().forEach(printWriter::println);
                });
        printWriter.flush();
    }

    public void statistics(PrintStream out) {
        PrintWriter printWriter = new PrintWriter(out);
        DoubleSummaryStatistics dss = allShapes.stream().mapToDouble(Shape::CalculateArea).summaryStatistics();
        printWriter.println(String.format("count: %d \nsum: %.2f \nmin: %.2f \naverage: %.2f \nmax: %.2f",
                dss.getCount(),dss.getSum(),dss.getMin(), dss.getAverage(), dss.getMax()));
        printWriter.flush();
    }
}
