import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TDFFileReader {
    private Scanner scanner;
    public TDFFileReader(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        scanner = new Scanner(file);
    }

    public List<Cyclist> readFile(){
        ArrayList<Cyclist> cyclists = new ArrayList<>();

        while (scanner.hasNext()){
            String[] splitLine = scanner.nextLine().split(";");

            cyclists.add(new Cyclist(splitLine[2], splitLine[1]));
        }
        scanner.close();

        return cyclists;
    }
}
