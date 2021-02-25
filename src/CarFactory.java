import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarFactory {
    private static List<Car> carList = new ArrayList<>();
    private static HashMap<String, Integer> streetHash = new HashMap<String, Integer>();

    protected static void addCar(String[] streets) {
        carList.add(new Car(List.of(streets)));
        for (String street : streets)
            //streetHash.put()
    }

    protected static HashMap<String, Integer> getStreetList() {
        return streetHash;
    }

    private static class Car {
        List<String> streets = new ArrayList<>();

        public Car(List<String> streets) {
            this.streets = streets;
        }

        public List<String> getStreets() {
            return streets;
        }

        public void setStreets(List<String> streets) {
            this.streets = streets;
        }
    }
}
