
public class Main {

    public static void main(String[] args) {
        PeopleDatabase peopleDB = new PeopleDatabase();
        peopleDB.savePeople("Jeff", 30);

        MovieDatabase movieDB = new MovieDatabase();
        movieDB.saveMovie("lagoa azul", false);

        RentalService rentalService = new RentalService();
        rentalService.rent("jeff", "lagoa azul");

        rentalService.listRentedMovies();
    }

}
