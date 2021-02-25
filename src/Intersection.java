import java.util.ArrayList;

public class Intersection {
    private int id;
    private ArrayList<Street> inStreets;
    private ArrayList<Street> outStreets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Street> getInStreets() {
        return inStreets;
    }

    public void setInStreets(ArrayList<Street> inStreets) {
        this.inStreets = inStreets;
    }

    public ArrayList<Street> getOutStreets() {
        return outStreets;
    }

    public void setOutStreets(ArrayList<Street> outStreets) {
        this.outStreets = outStreets;
    }

}
