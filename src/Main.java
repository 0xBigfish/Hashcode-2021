import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("test");
        File example = new File("src/resources/TODO.todo");
        System.out.println(example.getName());
    }
}
