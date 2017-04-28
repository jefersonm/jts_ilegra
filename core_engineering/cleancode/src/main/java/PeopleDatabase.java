import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PeopleDatabase {

    public People findPeople(String name) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/jts?user=root&password=root&serverTimezone=UTC&verifyServerCertificate=false&useSSL=false");
            Statement stm = conn.createStatement();
            stm.execute("select * from people where name like '%"+name+"%';");
            ResultSet rs = stm.getResultSet();
            while(rs.next()) {
                People people = new People();
                people.setId(rs.getInt(1));
                people.setName(rs.getString(2));
                people.setAge(rs.getInt(3));
                return people;
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void savePeople(String name, int age) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/jts?user=root&password=root&serverTimezone=UTC&verifyServerCertificate=false&useSSL=false");
            Statement stm = conn.createStatement();
            stm.execute("INSERT INTO `jts`.`people`\n" +
                    "(`name`,\n" +
                    "`age`)\n" +
                    "VALUES\n" +
                    "('"+name+"',"+age+");\n");
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    public void updatePeople(int id, String name, int age) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/jts?user=root&password=root&serverTimezone=UTC&verifyServerCertificate=false&useSSL=false");
            Statement stm = conn.createStatement();
            stm.execute("UPDATE `jts`.`people`\n" +
                    "SET\n" +
                    "`name` = '"+name+"',\n" +
                    "`age` = "+age+"\n" +
                    "WHERE `idpeople` = "+id+";");
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    public void deletePeople(int id) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/jts?user=root&password=root&serverTimezone=UTC&verifyServerCertificate=false&useSSL=false");
            Statement stm = conn.createStatement();
            stm.execute("DELETE FROM `jts`.`people`\n" +
                        "WHERE `idpeople` = "+id+";");
        }catch(Exception e) {
            System.out.println(e);
        }
    }

}
