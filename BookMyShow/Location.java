package BookMyShow;

import BookMyShow.Enums.City;
import BookMyShow.Enums.State;

public class Location {
    private String addressLine1;
    private String addressLine2;
    private City city;
    private State state;
    private int pincode;

    Location(String addressLine1,
        String addressLine2,
        City city,
        State state,
        int pincode) {
            this.addressLine1 = addressLine1;
            this.addressLine2 = addressLine2;
            this.city = city;
            this.state = state;
            this.pincode = pincode;
    }

    public City getCity() {
        return city;
    }

    public String toString() {
        return addressLine1 + ", " + addressLine2 + ", " + city.toString() + ", " + state.toString() + ", " + pincode;
    }
}
