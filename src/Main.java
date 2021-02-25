import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class Main {
    private static Integer simulation_time;
    private static Integer intersections;
    private static Integer streets;
    private static Integer cars;
    private static Integer bouns;
    private  static int counter = 1;

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


        while(counter<=streets){
            String[] streets_splited=input.get(counter).split(" ");
            Integer begining=Integer.parseInt(streets_splited[0]),
                    ending=Integer.parseInt(streets_splited[1]),
                    time=Integer.parseInt(streets_splited[3]);
            StreetFactory.addStreet(begining,ending,streets_splited[2],time);
            ++counter;
        }

        while (counter<=cars){
            String[] cars_splited=input.get(counter).split(" ");
            CarFactory.addCar(Arrays.copyOfRange(cars_splited, 1, Integer.parseInt(cars_splited[0])+1));
            ++counter;
        }

    }
}
