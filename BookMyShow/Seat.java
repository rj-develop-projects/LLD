package BookMyShow;

import BookMyShow.Enums.SeatType;

public class Seat {
    private int id;
    private int seatNum;
    private int seatPrice = 200;
    private SeatType seatType;

    public int getPrice() {
        switch(seatType) {
            case SILVER:
                seatPrice = 200;
            case GOLD:
                seatPrice = 300;
            case PLATINUM:
                seatPrice = 500;
        }
        return seatPrice;
    }

    public Seat(int seatNum,
        SeatType seatType) {
            id = BookMyShow.generateId();
            this.seatNum = seatNum;
            this.seatType = seatType;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public String toString() {
        return "Seat Number: " + seatNum + ", Seat Type: " + seatType.toString() + ", Seat Price: " + getPrice();
    }
}
