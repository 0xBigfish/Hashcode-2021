import java.io.*;
import java.util.ArrayList;

public class ScanFile {

    private Integer totalSimulationTime;
    private Integer intersections;
    private Integer numberOfStreets;
    private Integer totalNumberCars;
    private Integer score;

    public void read(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            readFirstLine(br);
            readStreets(br);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFirstLine(BufferedReader br) throws IOException {
        String[] firstLine = br.readLine().split(" ");
        totalSimulationTime = Integer.valueOf(firstLine[0]);
        intersections = Integer.valueOf((firstLine[1]));
        numberOfStreets = Integer.valueOf((firstLine[2]));
        totalNumberCars = Integer.valueOf((firstLine[3]));
        score = Integer.valueOf((firstLine[4]));
        System.out.println("Total Simulation Time: " + totalSimulationTime);
        System.out.println("Number of Intersections: " + intersections);
        System.out.println("Number of Streets: " + numberOfStreets);
        System.out.println("Total Number of Cars: " + totalNumberCars);
        System.out.println("Score: " + score);
    }

    private void readStreets(BufferedReader br) throws IOException {
        ArrayList<Street> streets = new ArrayList<>();
        for (Integer i = 0; i < numberOfStreets; i++) {
            String[] line = br.readLine().split(" ");
            Street street = new Street(
                    i,
                    Integer.valueOf(line[0]),
                    Integer.valueOf(line[1]),
                    line[2],
                    Integer.valueOf(line[3])
            );
            streets.add(street);
        }
        System.out.println("\nStreets: ");
        streets.forEach(s -> {
            System.out.println(s.getName());
        });

    }
}
