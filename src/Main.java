import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    private static Integer simulation_time;
    private static Integer intersections;
    private static Integer streets;
    private static Integer cars;
    private static Integer bouns;

    public static void Set(Integer simulation_time, Integer intersections, Integer streets, Integer cars, Integer bouns) {
        Main.simulation_time = simulation_time;
        Main.intersections = intersections;
        Main.streets = streets;
        Main.cars = cars;
        Main.bouns = bouns;
    }

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("a.txt"));
        // input : first line --> duration of the simulation : intersictions : streets : cars : bouns score for cars reach in duration of simulation
        // sec line streets time --> Begining intersiction : ending intersiction : name of street : length of street in secs
        // third line times of cars --> number of streets the car wants to travel : the end of the named street : and then the path
        String[] first_line = input.get(0).split(" ");
        simulation_time = Integer.parseInt(first_line[0]);
        intersections = Integer.parseInt(first_line[1]);
        streets = Integer.parseInt(first_line[2]);
        cars = Integer.parseInt(first_line[3]);
        bouns = Integer.parseInt(first_line[4]);
        int counter = 0;


    }
}
