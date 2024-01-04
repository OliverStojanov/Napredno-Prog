package Zad2;

import java.util.Comparator;

public class BookPriceComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        int x = Float.compare(o1.price,o2.price);
        if(x==0){
            return o1.title.compareTo(o2.title);
        }
        return x;
    }
}
