package Zad2;

import java.util.Comparator;

public class BookCategoryComparator implements Comparator<Book> {


    @Override
    public int compare(Book o1, Book o2) {
        int x = o1.title.compareTo(o2.title);
        if(x==0){
            return Float.compare(o1.price,o2.price);
        }
        return x;
    }
}
