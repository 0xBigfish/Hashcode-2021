import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SimpleSolution {

    private File file;

    public SimpleSolution(File file) {
        this.file = file;
    }

    public void go(ArrayList<Intersection> intersections) throws IOException {
        StringBuilder result = new StringBuilder();

        result.append(intersections.size()).append("\n");
        for (Intersection inters : intersections) {
            result.append(inters.getId()).append("\n");
            result.append(inters.getInStreets().size()).append("\n");
            for (Street inStreet : inters.getInStreets()){
                result.append(inStreet.getName()).append(" 1\n");
            }
        }
        File outputFile = new File("src/resources/" + file.getName().substring(0, file.getName().length() - 3) + "out");
        if (outputFile.createNewFile()) {
            System.out.println("Output file created at " + outputFile.getAbsolutePath());
        } else {
            System.out.println("Writing output to " + outputFile.getAbsolutePath());
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
        bw.write(result.toString());
        bw.close();
        System.out.println(result);

    }
}
