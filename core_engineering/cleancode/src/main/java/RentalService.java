import java.util.List;

public class RentalService {

    PeopleDatabase peopleDatabase;
    MovieDatabase movieDatabase;
    MoviePeopleDatabase moviePeopleDatabase;

    public void rent(String peopleName, String movieName) {
        movieDatabase = new MovieDatabase();
        peopleDatabase = new PeopleDatabase();
        moviePeopleDatabase = new MoviePeopleDatabase();

        Movie databaseMovie = movieDatabase.findMovie(movieName);
        People databasePeople = peopleDatabase.findPeople(peopleName);

        if (databaseMovie == null || databasePeople == null) {
            System.out.println("movie or people not found");
        }

        if(!databaseMovie.isRented()) {

            databaseMovie.setRented(true);
            movieDatabase.updateMovie(databaseMovie.getId(), databaseMovie.getName(), databaseMovie.isRented());

            moviePeopleDatabase.rentMovie(databaseMovie.getId(), databasePeople.getId());

            System.out.println("Movie rented");
        } else {
            System.out.println("This movie is already rented");
        }
    }

    public void listRentedMovies() {
        moviePeopleDatabase = new MoviePeopleDatabase();
        List<MoviePeople> rentedMovies = moviePeopleDatabase.findRentedMovies();
        for(MoviePeople rent : rentedMovies) {
            System.out.println("=== Rented movies ===");
            System.out.println("Movie name: " + rent.getMovie().getName());
            System.out.println("Person that rented the movie: " + rent.getPeople().getName());
        }
    }

}
