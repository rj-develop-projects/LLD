package BookMyShow;

import BookMyShow.Enums.City;

public class User {
    private int id;
    private String name;
    private City city;

    public User(String name, City city) {
        id = BookMyShow.generateId();
        this.name = name;
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city.toString() +
                '}';
    }
}
