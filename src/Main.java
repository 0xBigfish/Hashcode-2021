import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        File example = new File("src/resources/f.txt");
        ScanFile scanner = new ScanFile();
        scanner.read(example);
    }
}
