package BookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Show {
    private int id;
    private String startTime;
    private List<Integer> bookedSeatNums;
    private Screen screen;
    private Movie movie;

    public Show(String startTime, Screen screen, Movie movie) {
        id = BookMyShow.generateId();
        this.startTime = startTime;
        this.screen = screen;
        this.movie = movie;
        this.bookedSeatNums = new ArrayList<>(); 
    }

    public void addBookedSeat(int seatNum) {
        bookedSeatNums.add(seatNum);
    }

    public Movie getMovie() {
        return movie;
    }

    public String getStartTime() {
        return startTime;
    }

    public List<Integer> getBookedSeatNums() {
        return bookedSeatNums;
    }

    public Screen getScreen() {
        return screen;
    }

    public String toString() {
        return "Show: {id=" + id + ", startTime=" + startTime + ", screen=" + screen.toString() + ", movie=" + movie.toString() + "}";
    }
}
