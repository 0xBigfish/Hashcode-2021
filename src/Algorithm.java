import java.util.ArrayList;

public class Algorithm {
    public void move(Integer totalSimulationTime,
                     Integer numberOfIntersections,
                     Integer numberOfStreets,
                     Integer score,
                     ArrayList<Street> streets,
                     ArrayList<Intersection> intersections,
                     ArrayList<Car> cars) {

        for(int t = 1; t < totalSimulationTime + 1; t++){

            // udpate streets
            for(Street street : streets){
                // update the car positions ON the streets
                ArrayList<Car> positions = street.getPositions();

                Car car = positions.get(street.getStreetLength() - 1);
                if (car != null) {
                    positions.remove(car);
                    for (int i = 0; i < car.getPath().size(); i++) {
                        if (car.getPath().get(i) == street) {
                            int nextIntersectionID = car.getPath().get(i + 1).getStartIntersection();

                            intersections.get(nextIntersectionID).getQueue().add(car);
                        }
                    }
                }

                // move the cars starting from the front to the back
                for (int i = positions.size()-2; i >= 0; i--){
                    Car carToMove = positions.remove(i);
                    positions.set(i+1, carToMove);
                }
            }

            // update intersections (queues and traffic lights)
            for(Intersection intersection : intersections){

                // an intersection need more than just one queue -> one for each incoming street
                Car carToPassIntersection = intersection.getQueue().remove(0);
            }
        }
    }
}
