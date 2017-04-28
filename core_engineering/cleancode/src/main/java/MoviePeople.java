
public class MoviePeople {

    private Movie movie;
    private People people;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "MoviePeople{" +
                "movie=" + movie +
                ", people=" + people +
                '}';
    }
}
