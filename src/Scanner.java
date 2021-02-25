import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class Scanner {

    public Tuple<HashMap<Integer, Integer>, ArrayList<Library>> readFile(File file){

        try( BufferedReader br = new BufferedReader(new FileReader(file))){
            String[] first_line = br.readLine().split("\\s+");

            int n_of_books = Integer.parseInt(first_line[0]);
            int n_of_libraries = Integer.parseInt(first_line[1]);
            int n_of_days = Integer.parseInt(first_line[2]);

            String[] second_line = br.readLine().split("\\s+");

            // create a dictionary of book ids with their corresponding values
            HashMap<Integer, Integer> book_scores = new HashMap<>();
            int id = 0;
            for (String book_score : second_line){
                book_scores.put(id, Integer.parseInt(book_score));
                id++;
            }


            // here come the n_of_libraries segments describing each individual library
            // each segment is exactly two lines long
            ArrayList<Library> library_list = new ArrayList<>();
            for (int i = 0; i < n_of_libraries; i++){
                // read first line
                String[] segment_first_line = br.readLine().split("\\s+");
                Library lib = new Library(Integer.parseInt(segment_first_line[1]),
                        Integer.parseInt(segment_first_line[2]));

                // read second line
                String[] segments_second_line = br.readLine().split("\\s+");
                for (String book : segments_second_line) {
                    lib.addBook(Integer.parseInt(book));
                }

                library_list.add(lib);
            }

            return new Tuple<HashMap<Integer, Integer>, ArrayList<Library>>(book_scores, library_list);


        } catch (FileNotFoundException fnfe){
            System.out.println("an error occured while trying to read the input file");
            fnfe.printStackTrace();

        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args){
        String FILE = "Hash Code 2020 - Online Qualification Round/a_example.txt";
        readFile(new File(FILE));
    }
}
