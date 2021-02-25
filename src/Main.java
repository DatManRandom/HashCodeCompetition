import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("a.txt"));
        // input : first line --> duration of the simulation : intersictions : streets : cars : bouns score for cars reach in duration of simulation
        // sec line streets time --> Begining intersiction : ending intersiction : name of street : length of street in secs
        // third line times of cars --> number of streets the car wants to travel : the end of the named street : and then the path
    }
}
