package Zad58;

import java.util.Comparator;

public class CoefRatingComparator implements Comparator<Movie>{

    int maxRatings;

    public CoefRatingComparator(int maxRatings) {
        this.maxRatings = maxRatings;
    }

    @Override
    public int compare(Movie o1, Movie o2) {
        return Double.compare(o1.average()*o1.ratings.size()/maxRatings,o2.average()*o2.ratings.size()/maxRatings);
    }
}
