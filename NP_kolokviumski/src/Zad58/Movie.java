package Zad58;

import java.util.ArrayList;
import java.util.List;

public class Movie{
    String title;
    List<Integer> ratings;

    public Movie(String title, int [] ratings) {
        this.title = title;
        this.ratings = new ArrayList<>();
        for (int rating: ratings) {
            this.ratings.add(rating);
        }
    }

    public String getTitle() {
        return title;
    }

    public int numOfRatings() {
        return ratings.size();
    }

    public double average(){
        return ratings.stream().mapToDouble(rating -> rating).sum() / ratings.size();
    }

    @Override
    public String toString() {
        return String.format("%s (%.2f) of %d ratings", title, average(), ratings.size());
    }

    public String subTitleStr(){
        return title.substring(title.length()-6,title.length());
    }
}
