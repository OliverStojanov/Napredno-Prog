package Zad58;

import java.util.*;
import java.util.stream.Collectors;

public class MoviesList {
    static List<Movie> movies;

    public MoviesList() {
        movies = new ArrayList<>();
    }

    public void addMovie(String title, int[] ratings) {
        movies.add(new Movie(title,ratings));
    }

    public List<Movie> top10ByAvgRating() {
        return movies.stream()
                .sorted(Comparator.comparing(Movie::average).reversed().thenComparing(Movie::getTitle))
                .limit(10)
                .collect(Collectors.toList());
    }
    public int getMaxRatings(){
        return movies.stream().mapToInt(movie -> movie.ratings.size()).sum();
    }

    public List<Movie> top10ByRatingCoef() {
        Collections.sort(movies, new CoefRatingComparator(getMaxRatings()).reversed().thenComparing(Movie::getTitle));
        List<Movie> list = movies.stream()
                .limit(10)
                .collect(Collectors.toList());

        return list.stream()
                .sorted(Comparator.comparing(Movie::subTitleStr).reversed())
                .collect(Collectors.toList());
    }
}
