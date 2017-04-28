import org.junit.Assert;
import org.junit.Test;


public class MovieDatabaseTest {
    @Test
    public void findExistentMovie(){
        MovieDatabase createMovieDB = new MovieDatabase();
        createMovieDB.saveMovie("Tubarao", false);

        Movie expectedMovie = new Movie();
        expectedMovie.setName("Tubarao");

        Movie actualMovie = createMovieDB.findMovie("Tubarao");
        Assert.assertEquals(expectedMovie.getName(), actualMovie.getName());
    }
    @Test
    public void findNotExistentMovie(){
        MovieDatabase createMovieDB = new MovieDatabase();

        Movie actualMovie = createMovieDB.findMovie("Chamado");
        Assert.assertNotNull(actualMovie);
    }
}
