import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    protected static List<Car> carList = new ArrayList<>();
    //private static HashMap<String, Integer> streetHash = new HashMap<String, Integer>();

    protected static void addCar(String[] streets) {
        int score = 0;
        for (String street : streets) {
            if (StreetFactory.streetHash.containsKey(street))
                score += StreetFactory.streetHash.get(street).getTime();
        }
        carList.add(new Car(List.of(streets), score));
    }

    protected static class Car {
        List<String> streets = new ArrayList<>();
        int score;

        public Car(List<String> streets, int score) {
            this.streets = streets;
            this.score = score;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public List<String> getStreets() {
            return streets;
        }

        public void setStreets(List<String> streets) {
            this.streets = streets;
        }
    }
}
