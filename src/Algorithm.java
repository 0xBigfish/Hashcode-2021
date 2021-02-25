import java.util.ArrayList;

public class Algorithm {

    private ArrayList<Intersection> intersections = new ArrayList<>();

    public void go(Integer totalSimulationTime,
                   Integer numberOfIntersections,
                   Integer numberOfStreets,
                   Integer score,
                   ArrayList<Street> streets,
                   ArrayList<Car> cars){
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

        });

    }
}
