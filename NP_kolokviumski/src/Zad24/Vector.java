package Zad24;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Vector {
    public static final Vector DEFAULT = new Vector(Arrays.asList(5,5,5,5,5));
    static final Vector IDENTITY = new Vector(Arrays.asList(0, 0, 0, 0, 0));
    public List<Integer> numbers;

    public Vector(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int size(){
        return numbers.size();
    }
    public Vector sum(Vector other){
        return  new Vector(IntStream.range(0,other.size())
                .map(i -> this.numbers.get(i) + other.numbers.get(i))
                .boxed()
                .collect(Collectors.toList()));
    }
    public int max() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max().orElse(0);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
