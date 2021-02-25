import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarFactory {
    protected static List<Car> carList = new ArrayList<>();

    protected static void addCar(String[] streets) {
        int score = 0;
        for (String street : streets) {
            if (StreetFactory.streetHash.containsKey(street))
                score += StreetFactory.streetHash.get(street).getTime();
        }
        carList.add(new Car(List.of(streets), score));
    }

    protected static void sortCars() {
        carList.sort(Comparator.comparingInt(Car::getScore));
    }

    protected static class Car {
        List<String> streets;
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
