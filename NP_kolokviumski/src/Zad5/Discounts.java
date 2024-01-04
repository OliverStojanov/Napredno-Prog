package Zad5;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Discounts {
    List<Store> stores = new ArrayList<>();
    public int readStores(InputStream in) {
        stores = new BufferedReader(new InputStreamReader(in))
                .lines()
                .map(Store::ofLine)
                .collect(Collectors.toList());
        return stores.size();
    }

    public List<Store> byAverageDiscount() {
        return stores.stream().sorted(Comparator.comparing(Store::AverageDiscount).reversed().thenComparing(Store::getName)).limit(3).collect(Collectors.toList());
    }

    public List<Store> byTotalDiscount() {
        return stores.stream().sorted(Comparator.comparing(Store::TotalDiscount)).limit(3).collect(Collectors.toList());
    }
}
