package Zad2;

import java.util.Objects;

public class Book{
    public String title;
    public String category;
    public float price;

    public Book(String title, String category, float price) {
        this.title = title;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Book %s (%s) %.2f",title, category, price);
    }

}
