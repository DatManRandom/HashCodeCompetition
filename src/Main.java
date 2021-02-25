import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    private static Integer simulation_time;
    private static Integer intersections;
    private static Integer streets;
    private static Integer cars;
    private static Integer bouns;
    private static int counter = 1;

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("a.txt"));
        // input : first line --> duration of the simulation : intersictions : streets : cars : bouns score for cars reach in duration of simulation
        // sec line streets time --> Begining intersiction : ending intersiction : name of street : length of street in secs
        // third line times of cars --> number of streets the car wants to travel : the end of the named street : and then the path
        String[] first_line = input.get(0).split(" ");
        simulation_time = Integer.parseInt(first_line[0]);
        intersections = Integer.parseInt(first_line[1]);
        streets = Integer.parseInt(first_line[2]);
        cars = Integer.parseInt(first_line[3]) + streets;
        bouns = Integer.parseInt(first_line[4]);


        while (counter <= streets) {
            String[] streets_splited = input.get(counter).split(" ");
            Integer begining = Integer.parseInt(streets_splited[0]),
                ending = Integer.parseInt(streets_splited[1]),
                time = Integer.parseInt(streets_splited[3]);
            StreetFactory.addStreet(begining, ending, streets_splited[2], time);
            ++counter;
        }

        while (counter <= cars) {
            String[] cars_splited = input.get(counter).split(" ");
            CarFactory.addCar(Arrays.copyOfRange(cars_splited, 1, cars_splited.length - 1));
            ++counter;
        }

        StreetFactory.setStartingCarScore();
        StreetFactory.setTripCarScore();

        HashMap<Integer, List<StreetFactory.Street>> intersections = new HashMap<>();
        for (Map.Entry<String, StreetFactory.Street> street : StreetFactory.streetHash.entrySet()) {
            StreetFactory.Street value = street.getValue();
            List<StreetFactory.Street> streetAdd = intersections.getOrDefault(value.getEndIntersection(), new ArrayList<>());
            streetAdd.add(value);
            intersections.put(value.getEndIntersection(), streetAdd);
        }

        for (Map.Entry<Integer, List<StreetFactory.Street>> intersection : intersections.entrySet()) {
            Integer key = intersection.getKey();
            List<StreetFactory.Street> value = intersection.getValue();
            IntersectionFactory.intersectionList.add(new IntersectionFactory.Intersection(key, value));
        }

        String output = "" + IntersectionFactory.intersectionList.size() + "\n";
        for (IntersectionFactory.Intersection intersection : IntersectionFactory.intersectionList) {
            output += intersection.getId() + "\n" + intersection.getStreetList().size() + "\n";
            for (StreetFactory.Street street : intersection.getStreetList())
                output += street.getStreetName() + " " + street.getLightTime() + "\n";
        }

        System.out.println(output);
        PrintWriter out = new PrintWriter("output.txt");
        out.println(out);

    }

}
