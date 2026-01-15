package BookMyShow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import BookMyShow.Enums.City;
import BookMyShow.Enums.PaymentMode;
import BookMyShow.Enums.PaymentStatus;
import BookMyShow.Enums.State;

public class BookMyShow {
    private TheatreController theatreController;
    private MovieController movieController;
    private static final Random random = new Random();

    public static int generateId() {
        return random.nextInt(10000) + 1;
    }

    public BookMyShow() {
        theatreController = new TheatreController();
        movieController = new MovieController();

        createMovies();
        createTheatres();
    }

    private void createMovies() {
        movieController.createMovie("BAHUBALI", 150, City.BANGALORE);
        movieController.createMovie("DEVA", 180, City.MUMBAI);
        movieController.createMovie("PADMAVATI", 160, City.JAIPUR);
    }

    private void createTheatres() {
        Location theatre1Address = new Location("blr1", null, City.BANGALORE, State.KARNATAKA, 123);
        Location theatre2Address = new Location("blr2", null, City.BANGALORE, State.KARNATAKA, 125);
        Location theatre3Address = new Location("mum1", null, City.MUMBAI, State.MAHARASTHRA, 323);
        Location theatre4Address = new Location("mum2", null, City.MUMBAI, State.MAHARASTHRA, 325);
        Location theatre5Address = new Location("jpr1", null, City.JAIPUR, State.RAJASTHAN, 521);

        Screen theatre1Screen1 = new Screen(100);
        Screen theatre1Screen2 = new Screen(120);
        Screen theatre2Screen1 = new Screen(70);
        Screen theatre2Screen2 = new Screen(90);
        Screen theatre3Screen1 = new Screen(100);
        Screen theatre3Screen2 = new Screen(130);
        Screen theatre3Screen3 = new Screen(80);
        Screen theatre4Screen1 = new Screen(90);
        Screen theatre4Screen2 = new Screen(110);
        Screen theatre5Screen1 = new Screen(100);
        Screen theatre1Screen3 = new Screen(150);

        // Create multiple shows for each screen
        String[] showTimes = {"10:00", "14:00", "18:00"};
        String[] movieNames = {"BAHUBALI", "DEVA", "PADMAVATI"};

        List<Show> theatre1Shows = new ArrayList<>();
        List<Show> theatre2Shows = new ArrayList<>();
        List<Show> theatre3Shows = new ArrayList<>();
        List<Show> theatre4Shows = new ArrayList<>();
        List<Show> theatre5Shows = new ArrayList<>();
        

        // Theatre 1
        for (String time : showTimes) {
            theatre1Shows.add(new Show(time, theatre1Screen1, movieController.getMovieByName(movieNames[random.nextInt(3)])));
            theatre1Shows.add(new Show(time, theatre1Screen2, movieController.getMovieByName(movieNames[random.nextInt(3)])));
            theatre1Shows.add(new Show(time, theatre1Screen3, movieController.getMovieByName(movieNames[random.nextInt(3)])));
        }

        // Theatre 2
        for (String time : showTimes) {
            theatre2Shows.add(new Show(time, theatre2Screen1, movieController.getMovieByName(movieNames[random.nextInt(3)])));
            theatre2Shows.add(new Show(time, theatre2Screen2, movieController.getMovieByName(movieNames[random.nextInt(3)])));
        }

        // Theatre 3
        for (String time : showTimes) {
            theatre3Shows.add(new Show(time, theatre3Screen1, movieController.getMovieByName(movieNames[random.nextInt(3)])));
            theatre3Shows.add(new Show(time, theatre3Screen2, movieController.getMovieByName(movieNames[random.nextInt(3)])));
            theatre3Shows.add(new Show(time, theatre3Screen3, movieController.getMovieByName(movieNames[random.nextInt(3)])));
        }

        // Theatre 4
        for (String time : showTimes) {
            theatre4Shows.add(new Show(time, theatre4Screen1, movieController.getMovieByName(movieNames[random.nextInt(3)])));
            theatre4Shows.add(new Show(time, theatre4Screen2, movieController.getMovieByName(movieNames[random.nextInt(3)])));
        }

        // Theatre 5
        for (String time : showTimes) {
            theatre5Shows.add(new Show(time, theatre5Screen1, movieController.getMovieByName(movieNames[random.nextInt(3)])));
        }

        theatreController.createTheatre(theatre1Address, theatre1Shows, Arrays.asList(theatre1Screen1, theatre1Screen2, theatre1Screen3));
        theatreController.createTheatre(theatre2Address, theatre2Shows, Arrays.asList(theatre2Screen1, theatre2Screen2));
        theatreController.createTheatre(theatre3Address, theatre3Shows, Arrays.asList(theatre3Screen1, theatre3Screen2, theatre3Screen3));
        theatreController.createTheatre(theatre4Address, theatre4Shows, Arrays.asList(theatre4Screen1, theatre4Screen2));
        theatreController.createTheatre(theatre5Address, theatre5Shows, Arrays.asList(theatre5Screen1));
    }       
    
    public Booking bookTicket(String movieName, User user, String showTimings, List<Integer> seatNums) {
        City userCity = user.getCity();
        Map<Theatre, List<Show>> allShowsInCity = theatreController.getAllShows(movieController.getMovieByName(movieName), userCity);
        Show interestedShow = null;
        Collections.sort(seatNums);
        for (Map.Entry<Theatre, List<Show>> entry : allShowsInCity.entrySet()) {
            List<Show> availableShows = entry.getValue().stream()
                                    .filter(show -> show.getScreen().getSeats().size() >= seatNums.get(seatNums.size() - 1))
                                    .filter(show -> show.getStartTime().equals(showTimings))
                                    .filter(show -> !show.getBookedSeatNums().stream().anyMatch(seatNum -> seatNums.contains(seatNum)))
                                    .collect(Collectors.toList());
            if (availableShows.size() > 0) {
                interestedShow = availableShows.get(0);
                break;
            }
        }

        if (interestedShow == null) {
            System.out.println("No shows available for the given criteria");
            return null;
        }

        List<Seat> interestedSeats = interestedShow.getScreen().getSeats().stream().filter(seat -> seatNums.contains(seat.getSeatNum())).collect(Collectors.toList());

        Booking booking = new Booking(user, interestedShow, interestedSeats);
        Payment payment = new Payment(booking.getId(), booking.getTotalAmount(), PaymentMode.UPI, PaymentStatus.SUCCEEDED);
        booking.setPayment(payment);
        
        if (payment.getPaymentStatus() == PaymentStatus.SUCCEEDED) {
            for (int seatNum : seatNums) {
                interestedShow.addBookedSeat(seatNum);
            }
        }

        System.out.println(booking);

        return booking;
    }
}
