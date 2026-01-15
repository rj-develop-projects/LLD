package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BookMyShow.Enums.City;

public class MovieController {
    private Map<City, List<Movie>> cityToMovies;
    private List<Movie> allMovies;

    public MovieController() {
        cityToMovies = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public Movie createMovie(String name, int durationInMins, City city) {
        Movie movie = new Movie(name, durationInMins);
        System.out.println("Movie created: " + movie.toString());
        allMovies.add(movie);
        List<Movie> moviesInCity = cityToMovies.getOrDefault(city, new ArrayList<>());
        moviesInCity.add(movie);
        cityToMovies.put(city, moviesInCity);
              
        return movie;
    }

    public Map<City, List<Movie>> getCityToMovies() {
        return cityToMovies;
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    public Movie getMovieByName(String name) {
        return allMovies.stream().filter(movie -> movie.getName().equals(name)).findFirst().orElse(null);
    }
}
