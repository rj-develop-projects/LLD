package BookMyShow;

import java.util.List;
import java.util.stream.Collectors;

public class Theatre {
    private int id;
    private Location address;
    private List<Show> shows;
    private List<Screen> screens;

    public Theatre(Location address, List<Show> shows, List<Screen> screens) {
        id = BookMyShow.generateId();
        this.address = address;
        this.shows = shows;
        this.screens = screens;
    }

    public List<Show> getShows() {
        return shows;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Theatre{");
        sb.append("id=").append(id).append(", ");
        sb.append("address=").append(address.toString()).append(", ");
        sb.append("shows=").append(shows.stream().map(Show::toString).collect(Collectors.joining(", "))).append(", ");
        sb.append("screens=").append(screens.stream().map(Screen::toString).collect(Collectors.joining(", ")));
        sb.append("}");
        return sb.toString();
    }
}
