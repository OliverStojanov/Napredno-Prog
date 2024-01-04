package Zad61;

import java.util.Comparator;

public class ProductComparator {
    static Comparator<Product> crateComparator(COMPARATOR_TYPE comparatorType){
        switch (comparatorType){
            case NEWEST_FIRST: return Comparator.comparing(Product::getCreatedAt).reversed();
            case OLDEST_FIRST: return Comparator.comparing(Product::getCreatedAt);
            case HIGHEST_PRICE_FIRST: return Comparator.comparing(Product::getPrice).reversed();
            case LOWEST_PRICE_FIRST: return Comparator.comparing(Product::getPrice);
            case MOST_SOLD_FIRST: return Comparator.comparing(Product::getMostSold).reversed();
            default: return  Comparator.comparing(Product::getMostSold);
        }
    }
}
