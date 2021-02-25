import java.util.ArrayList;

public class Car {
    private Integer id;
    private ArrayList<Street> path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Street> getPath() {
        return path;
    }

    public void setPath(ArrayList<Street> path) {
        this.path = path;
    }
}
