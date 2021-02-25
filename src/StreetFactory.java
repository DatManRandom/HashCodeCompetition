import java.util.ArrayList;
import java.util.List;

public class StreetFactory {
    private static List<Street> streetList = new ArrayList<>();

    protected static void addStreet(String name, int startInt, int endInt) {
        streetList.add(new Street(startInt, endInt, name));
    }


    private static class Street {
        private int startIntersection;
        private int endIntersection;
        private String streetName;

        public int getStartIntersection() {
            return startIntersection;
        }

        public void setStartIntersection(int startIntersection) {
            this.startIntersection = startIntersection;
        }

        public int getEndIntersection() {
            return endIntersection;
        }

        public void setEndIntersection(int endIntersection) {
            this.endIntersection = endIntersection;
        }

        public String getStreetName() {
            return streetName;
        }

        public void setStreetName(String streetName) {
            this.streetName = streetName;
        }

        public Street(int startIntersection, int endIntersection, String streetName) {
            this.startIntersection = startIntersection;
            this.endIntersection = endIntersection;
            this.streetName = streetName;

        }
    }
}
