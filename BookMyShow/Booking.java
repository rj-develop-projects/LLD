package BookMyShow;

import java.util.List;

public class Booking {
    private int id;
    private User user;
    private Show show;
    private Payment payment;
    private List<Seat> seats;

    public Booking(User user, Show show, List<Seat> seats) {
        this.id = BookMyShow.generateId();
        this.user = user;
        this.show = show;
        this.seats = seats;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public int getTotalAmount() {
        int totalAmount = 0;
        for (Seat seat : seats) {
            totalAmount += seat.getPrice();
        }
        return totalAmount;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder seatsString = new StringBuilder();
        seats.stream().forEach(seat -> seatsString.append(seat.toString()));
        return "Booking{" +
                "id=" + id +
                ", user=" + user.toString() +
                ", show=" + show.toString() +
                ", payment=" + payment.toString() +
                ", seats=" + seatsString.toString() +
                ", totalAmount=" + getTotalAmount() +
                '}';
    }
}
