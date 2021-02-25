import java.util.HashMap;

public class StreetFactory {
    protected static HashMap<String, Street> streetHash = new HashMap<>();

    protected static void addStreet(int startInt, int endInt, String name, int time) {
        streetHash.put(name, new Street(startInt, endInt, name, time));

    }


    protected static class Street {
        private int startIntersection;
        private int endIntersection;
        private String streetName;
        private int time;

        public Street(int startIntersection, int endIntersection, String streetName, int time) {
            this.startIntersection = startIntersection;
            this.endIntersection = endIntersection;
            this.streetName = streetName;
            this.time = time;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

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
    }
}
