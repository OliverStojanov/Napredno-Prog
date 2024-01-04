package Zad5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Store {
    public String name;
    public List<Product> products;

    public Store(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public static Store ofLine(String s) {
        String []parts = s.split("\\s+");
        return  new Store(parts[0], Arrays.stream(parts).skip(1).map(Product::ofString).collect(Collectors.toList()));
    }
    public String getName(){
        return name;
    }
    public double AverageDiscount(){
        return products.stream().mapToDouble(Product::Discount).average().orElse(0);
    }
    public int TotalDiscount(){
        return products.stream().mapToInt(Product::AbsoluteDiscount).sum();
    }

    @Override
    public String toString() {
        String str = products.stream().sorted(Comparator.comparing(Product::Discount).thenComparing(Product::AbsoluteDiscount).reversed())
                .map(Product::toString).collect(Collectors.joining("\n"));
        double rounded = Math.round(AverageDiscount() * 10)/10.0;
        return String.format("%s\nAverage discount: %.1f%%\nTotal discount: %d\n%s",name, rounded, TotalDiscount(), str);
    }
}
