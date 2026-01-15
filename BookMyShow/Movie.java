package BookMyShow;


public class Movie {

    private int id;
    private String name;
    private int durationInMins;

    public Movie(String name, int durationInMins) {
        id = BookMyShow.generateId();
        setName(name);
        setDurationInMins(durationInMins);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDurationInMins() {
        return durationInMins;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDurationInMins(int durationInMins) {
        this.durationInMins = durationInMins;
    }

    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", durationInMins=" + durationInMins +
                '}';
    }

}
