
public class Movie {

    private int id;
    private String name;
    private boolean rented;

    public Movie(){
        this.name = "nao cadastrado";
    }

    public Movie(String name){
        this.name = name;
        this.rented = false;
    }

    public Movie(int id, String name, boolean rented){
        this.id = id;
        this.name = name;
        this.rented = rented;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rented=" + rented +
                '}';
    }
}
