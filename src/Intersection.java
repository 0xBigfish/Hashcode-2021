import java.util.ArrayList;

public class Intersection {
    private int id;
    private ArrayList<Street> inStreets;
    private ArrayList<Street> outStreets;
    private ArrayList<Car> queue = new ArrayList<>();
    private ArrayList<Boolean> trafficLights = new ArrayList<>();
    private ArrayList<Integer> greenTime = new ArrayList<>();
    
    public Intersection() {

    }

    public boolean isGreen(){
        return trafficLights.contains(true);
    }
    
    
    public Street getGreenLight(){
        for(int i = 0; i < trafficLights.size(); i++){
            if(trafficLights.get(i)){
                return inStreets.get(i);
            }
        }
        return null;
    }

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
        initializeTrafficLights(inStreets);
    }

    private void initializeTrafficLights(ArrayList<Street> inStreets) {
        inStreets.forEach(s -> {
            trafficLights.add(false);
        });

        inStreets.forEach(s -> {
            greenTime.add(0);
        });
    }

    public ArrayList<Street> getOutStreets() {
        return outStreets;
    }

    public void setOutStreets(ArrayList<Street> outStreets) {
        this.outStreets = outStreets;
    }


    public ArrayList<Car> getQueue() {
        return queue;
    }

    public void setQueue(ArrayList<Car> queue) {
        this.queue = queue;
    }

    public ArrayList<Boolean> getTrafficLights() {
        return trafficLights;
    }

    public void setTrafficLights(ArrayList<Boolean> trafficLights) {
        this.trafficLights = trafficLights;
    }

    public int getGreenTime() {

        return greenTime;
    }

}
