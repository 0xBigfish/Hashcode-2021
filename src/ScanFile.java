import java.io.*;
import java.math.BigInteger;

public class ScanFile {

    private BigInteger totalSimulationTime;
    private BigInteger intersections;
    private BigInteger streets;
    private BigInteger totalNumberCars;
    private BigInteger score;

    public void read(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            readFirstLine(br);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFirstLine(BufferedReader br) throws IOException {
        String[] firstLine = br.readLine().split(" ");
        totalSimulationTime = BigInteger.valueOf(Long.valueOf(firstLine[0]));
        intersections = BigInteger.valueOf(Long.valueOf(firstLine[1]));
        streets = BigInteger.valueOf(Long.valueOf(firstLine[2]));
        totalNumberCars = BigInteger.valueOf(Long.valueOf(firstLine[3]));
        score = BigInteger.valueOf(Long.valueOf(firstLine[4]));
        System.out.println("Total Simulation Time: " + totalSimulationTime);
        System.out.println("Number of Intersections: " + intersections);
        System.out.println("Streets: " + streets);
        System.out.println("Total Number of Cars: " + totalNumberCars);
        System.out.println("Score: " + score);
    }
}
