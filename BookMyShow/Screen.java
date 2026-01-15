package BookMyShow;

import java.util.ArrayList;
import java.util.List;

import BookMyShow.Enums.SeatType;

public class Screen {
    private int id;
    private List<Seat> seats;

    public Screen(int numOfSeats) {
        id = BookMyShow.generateId();
        initializeSeats(numOfSeats);
    }

    private void initializeSeats(int numOfSeats) {
        seats = new ArrayList<>();
        for (int i = 1; i <= numOfSeats; i++) {
            SeatType seatType;
            if (i <= numOfSeats* 0.6) {
                seatType = SeatType.SILVER;
            } else if ( i <= numOfSeats*0.9) {
                seatType = SeatType.GOLD;
            } else {
                seatType = SeatType.PLATINUM;
            }
            seats.add(new Seat(i, seatType));
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public String toString() {
        return "Screen{" +
                "id=" + id +
                "seats size=" + seats.size() +
                '}';
    }
}
