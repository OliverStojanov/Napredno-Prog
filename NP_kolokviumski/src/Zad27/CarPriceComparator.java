package Zad27;

import java.util.Comparator;

public class CarPriceComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        int a = o1.getPrice() - o2.getPrice();
        if (a == 0){
            return (int) (o1.getPower() - o2.getPower());
        }
        return a;
    }
}
