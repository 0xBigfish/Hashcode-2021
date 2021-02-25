import java.awt.*;
import java.util.ArrayList;

public class Algorithm {

    private ArrayList<Intersection> intersections = new ArrayList<>();

    public void go(Integer totalSimulationTime,
                   Integer numberOfIntersections,
                   Integer numberOfStreets,
                   Integer score,
                   ArrayList<Street> streets,
                   ArrayList<Car> cars){
        createIntersections(numberOfIntersections, streets);
        spawnCars(cars);
        debug();
    }

    private void createIntersections(Integer numberOfIntersections, ArrayList<Street> streets) {
        for(Integer i = 0; i < numberOfIntersections; i++){
            Intersection intersection = new Intersection();
            intersection.setId(i);

            Integer finalI = i;
            ArrayList<Street> outStreets = new ArrayList<>();
            ArrayList<Street> inStreets = new ArrayList<>();

            streets.forEach(street -> {
                if(street.getStartIntersection().equals(finalI)){
                    outStreets.add(street);
                }
                if(street.getEndIntersection().equals(finalI)){
                    inStreets.add(street);
                }
            });
            intersection.setOutStreets(outStreets);
            intersection.setInStreets(inStreets);
            intersections.add(intersection);
        }
    }

    private void spawnCars(ArrayList<Car> cars) {
        cars.forEach(car -> {
            Street start = car.getPath().get(0);
            intersections.forEach(intersection -> {
                if(intersection.getId() == start.getEndIntersection()){
                    intersection.getQueue().add(car);
                }
            });
        });
    }

    private void debug() {
        System.out.println("Intersections");
        intersections.forEach(intersection -> {
            System.out.println("\nIntersection: " + intersection.getId());
            System.out.print("In Streets: ");
            intersection.getInStreets().forEach(in -> {
                System.out.print(in.getName() + " ");
            });
            System.out.print("\nOut Streets: ");
            intersection.getOutStreets().forEach(out -> {
                System.out.print(out.getName() + " ");
            });
            System.out.print("\nCars in queue: ");
            intersection.getQueue()
                    .stream()
                    .map(Car::getId)
                    .forEach(System.out::print);
        });
    }
}
