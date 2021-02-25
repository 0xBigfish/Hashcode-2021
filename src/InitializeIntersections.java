import java.util.ArrayList;

public class InitializeIntersections {

    private ArrayList<Intersection> intersections = new ArrayList<>();

    public void go(Integer totalSimulationTime,
                   Integer numberOfIntersections,
                   Integer numberOfStreets,
                   Integer score,
                   ArrayList<Street> streets,
                   ArrayList<Car> cars){
        createIntersections(numberOfIntersections, streets);
        spawnCars(cars);
        activateTrafficLights();
        Algorithm alg = new Algorithm();
        alg.move(totalSimulationTime, numberOfIntersections, numberOfStreets, score, streets, intersections, cars);
        debug();
    }

    private void activateTrafficLights() {
        intersections.forEach(intersection -> {
            if (intersection.getQueue().size() > 0){
                Car firstCar = intersection.getQueue().get(0);
                Street onStreet = firstCar.getPath().get(0);
                for(int i = 0; i < intersection.getInStreets().size(); i++){
                    if(intersection.getInStreets().get(i).getId().equals(onStreet.getId())){
                        intersection.getTrafficLights().set(i, true);
                        intersection.getGreenTimeForEachLight().set(i,2);
                    }
                }

            }
        } );
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
            System.out.print("\nTraffic lights: ");
            intersection.getTrafficLights()
                    .forEach(t -> {
                        System.out.print(t + " ");
                    });

            System.out.println("\nEach Lights green time: ");
            intersection.getGreenTimeForEachLight()
                    .forEach(t -> {
                        System.out.print(t + " ");
                    });
        });
    }
}
