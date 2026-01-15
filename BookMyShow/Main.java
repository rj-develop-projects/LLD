package BookMyShow;

import java.util.Arrays;
import java.util.List;

import BookMyShow.Enums.City;

public class Main {

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        User user1 = new User("Rahul", City.BANGALORE);
        User user2 = new User("Bagmayee", City.MUMBAI);
        User user3 = new User("Ravi", City.BANGALORE);

        List<Integer> seatNums = Arrays.asList(90);

        bookMyShow.bookTicket("BAHUBALI", user1, "10:00", seatNums);
        bookMyShow.bookTicket("DEVA", user2, "10:00", seatNums);
        bookMyShow.bookTicket("BAHUBALI", user3, "10:00", Arrays.asList(64, 65));
    }

}
