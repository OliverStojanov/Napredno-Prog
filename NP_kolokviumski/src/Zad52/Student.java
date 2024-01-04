package Zad52;

import java.util.List;

public class Student {
    String index;
    List<Integer> points;
    public Student(String index, List<Integer> points) {
        this.index = index;
        this.points = points;
    }

    public double average(){
        return points.stream()
                .mapToInt(p->p)
                .sum()/10.0;
    }

    public String getIndex() {
        return index;
    }
    public boolean hasSignature(){
        return points.size() >=8;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", index , hasSignature()?"YES":"NO", average());
    }
}
