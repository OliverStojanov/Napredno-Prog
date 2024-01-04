package Zad2;

import java.util.*;

public class BookCollection {

    public List<Book> books;

    public BookCollection() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void printByCategory(String category) {
        List<Book> byCategory = new ArrayList<Book>();
        for (Book book : books){
            if(book.category.equalsIgnoreCase(category)){
                byCategory.add(book);
            }
        }
        Collections.sort(byCategory, new BookCategoryComparator());
        for (Book book : byCategory){
            System.out.println(book);
        }
    }

    public List<Book> getCheapestN(int n) {
        Collections.sort(books,new BookPriceComparator());
        if(n<books.size()){
            return books.subList(0,n);
        }
        return books;
    }
}
