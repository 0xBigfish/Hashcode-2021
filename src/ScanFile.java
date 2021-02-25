import java.io.*;

public class ScanFile {

    public void read(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
