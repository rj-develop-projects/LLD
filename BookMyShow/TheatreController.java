package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import BookMyShow.Enums.City;

public class TheatreController {
    private Map<City, List<Theatre>> cityToTheatres;
    private List<Theatre> allTheatres;

    public TheatreController() {
        cityToTheatres = new HashMap<>();
        allTheatres = new ArrayList<>();
    }

    public Theatre createTheatre(Location address, List<Show> shows, List<Screen> screens) {
        Theatre theatre = new Theatre(address, shows, screens);
        System.out.println("Created Theatre: " + theatre.toString());
        allTheatres.add(theatre);
        List<Theatre> theatresInCity = cityToTheatres.getOrDefault(address.getCity(), new ArrayList<>());
        theatresInCity.add(theatre);
        cityToTheatres.put(address.getCity(), theatresInCity);
        return theatre;
    }

    public Map<Theatre, List<Show>> getAllShows(Movie movie, City city) {
        Map<Theatre, List<Show>> allShowsOfMovieInCity = new HashMap<>();

        List<Theatre> theatresInCity = cityToTheatres.getOrDefault(city, null);

        for (Theatre theatre : theatresInCity) {
            List<Show> shows = theatre.getShows().stream().filter(show -> show.getMovie().equals(movie)).collect(Collectors.toList());
            allShowsOfMovieInCity.put(theatre, shows);
        }

        return allShowsOfMovieInCity;
    }
}
