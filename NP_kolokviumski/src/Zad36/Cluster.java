package Zad36;

import java.util.*;

public class Cluster<T extends Clusterable>{
    Map<Long,T> items;

    public Cluster() {
        items = new HashMap<>();
    }

    public void addItem(T point2D) {
        items.put(point2D.id(), point2D);
    }

    public void near(long id, int top) {
        List<T> list = new ArrayList<>(items.values());
        final T item = items.get(id);
        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return Double.compare(o1.distance(item), o2.distance(item));
            }
        });
        for (int i = 1; i <= top&&i < list.size(); ++i) {
            T e = list.get(i);
            System.out.printf("%d. %d -> %.3f\n", i, e.id(), e.distance(item));
        }
    }
}

