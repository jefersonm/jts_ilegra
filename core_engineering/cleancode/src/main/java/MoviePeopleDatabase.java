import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MoviePeopleDatabase {

    public List<MoviePeople> findRentedMovies() {
        List<MoviePeople> movies = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/jts?user=root&password=root&serverTimezone=UTC&verifyServerCertificate=false&useSSL=false");
            Statement stm = conn.createStatement();
            stm.execute("select p.idpeople, p.name, p.age, m.idmovie, m.name, m.rented " +
                    "from movie_people mp\n" +
                    "inner join people p on p.idpeople = mp.id_people\n" +
                    "inner join movie m on m.idmovie = mp.id_movie;");
            ResultSet rs = stm.getResultSet();

            while(rs.next()) {
                MoviePeople moviePeople = new MoviePeople();
                People people = new People();
                people.setId(rs.getInt(1));
                people.setName(rs.getString(2));
                people.setAge(rs.getInt(3));
                moviePeople.setPeople(people);

                Movie movie = new Movie();
                movie.setId(rs.getInt(4));
                movie.setName(rs.getString(5));
                movie.setRented(rs.getBoolean(6));
                moviePeople.setMovie(movie);

                movies.add(moviePeople);
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        return movies;
    }

    public void rentMovie(int movie_id, int people_id) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/jts?user=root&password=root&serverTimezone=UTC&verifyServerCertificate=false&useSSL=false");
            Statement stm = conn.createStatement();
            stm.execute("INSERT INTO `jts`.`movie_people`\n" +
                    "(`id_movie`,\n" +
                    "`id_people`)\n" +
                    "VALUES ("+movie_id+", "+people_id+");");
        }catch(Exception e) {
            System.out.println(e);
        }
    }

}
