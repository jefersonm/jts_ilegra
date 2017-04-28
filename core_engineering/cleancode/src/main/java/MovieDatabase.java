import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MovieDatabase {

    public Movie findMovie(String name) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/jts?user=root&password=root&serverTimezone=UTC&verifyServerCertificate=false&useSSL=false");
            Statement stm = conn.createStatement();
            stm.execute("select * from movie where name like '%"+name+"%';");
            ResultSet rs = stm.getResultSet();
            while(rs.next()) {
                return new Movie(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        return new Movie();
    }

    public void saveMovie(String name, boolean rented) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/jts?user=root&password=root&serverTimezone=UTC&verifyServerCertificate=false&useSSL=false");
            Statement stm = conn.createStatement();
            stm.execute("INSERT INTO `jts`.`movie`\n" +
                    "(`name`,\n" +
                    "`rented`)\n" +
                    "VALUES\n" +
                    "('"+name+"',"+rented+");\n");
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    public void updateMovie(int id, String name, boolean rented) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/jts?user=root&password=root&serverTimezone=UTC&verifyServerCertificate=false&useSSL=false");
            Statement stm = conn.createStatement();
            stm.execute("UPDATE `jts`.`movie`\n" +
                    "SET\n" +
                    "`name` = '"+name+"',\n" +
                    "`rented` = "+rented+"\n" +
                    "WHERE `idmovie` = "+id+";");
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    public void deleteMovie(int id) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/jts?user=root&password=root&serverTimezone=UTC&verifyServerCertificate=false&useSSL=false");
            Statement stm = conn.createStatement();
            stm.execute("DELETE FROM `jts`.`movie`\n" +
                        "WHERE `idmovie` = "+id+";");
        }catch(Exception e) {
            System.out.println(e);
        }
    }


}
