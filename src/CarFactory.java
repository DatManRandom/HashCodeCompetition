import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarFactory {
    private List<Car> carList = new ArrayList<>();

    protected static void addCar(String[] streets){
        carList.add(new Car(List.of(streets)));
    }

    private static class Car{
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
