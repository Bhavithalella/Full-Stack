import java.util.HashMap;
import java.util.Map;

class Movie {
    private String title;
    private String rating;
    private double ratingValue;

    public Movie(String title, String rating, double ratingValue) {
        this.title = title;
        this.rating = rating;
        this.ratingValue = ratingValue;
    }

    public String getRating() {
        return rating;
    }

    public double getRatingValue() {
        return ratingValue;
    }
}

public class MovieRatingsTracker {

    public static void main(String[] args) {
        Movie[] movies = {
                new Movie("Movie1", "PG", 4.5),
                new Movie("Movie2", "PG-13", 3.9),
                new Movie("Movie3", "R", 4.1),
                new Movie("Movie4", "PG", 4.2),
                new Movie("Movie5", "PG-13", 3.8)
        };

        Map<String, Integer> movieCount = new HashMap<>();
        Map<String, Double> movieTotalRating = new HashMap<>();

        for (Movie movie : movies) {
            String rating = movie.getRating();
            double ratingValue = movie.getRatingValue();

            // Update movie count
            movieCount.put(rating, movieCount.getOrDefault(rating, 0) + 1);

            // Update total rating
            movieTotalRating.put(rating, movieTotalRating.getOrDefault(rating, 0.0) + ratingValue);
        }

        System.out.println("Movie Ratings Summary:");
        for (Map.Entry<String, Integer> entry : movieCount.entrySet()) {
            String rating = entry.getKey();
            int count = entry.getValue();
            double totalRating = movieTotalRating.get(rating);
            double averageRating = totalRating / count;
            System.out.println("Rating: " + rating + ", Number of Movies: " + count + ", Average Rating: " + averageRating);
        }
    }
}
