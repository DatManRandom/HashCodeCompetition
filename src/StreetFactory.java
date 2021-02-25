import java.util.HashMap;
import java.util.Map;

public class StreetFactory {
    protected static HashMap<String, Street> streetHash = new HashMap<>();

    protected static void addStreet(int startInt, int endInt, String name, int time) {
        streetHash.put(name, new Street(startInt, endInt, name, time));
    }

    public static void setStartingCarScore() {
        for (Map.Entry<String, Street> street : streetHash.entrySet()) {
            String key = street.getKey();
            Street value = street.getValue();
            for (CarFactory.Car car : CarFactory.carList) {
                if (car.getStreets().get(0) == key) {
                    value.setStartingCarScore(value.getStartingCarScore() + car.getScore());
                    streetHash.put(key, value);
                }
            }
        }
    }

    //Score of car that moves in this street / number of streets this car moves in
    public static void setTripCarScore() {
        for (Map.Entry<String, Street> street : streetHash.entrySet()) {
            String key = street.getKey();
            Street value = street.getValue();
            for (CarFactory.Car car : CarFactory.carList) {
                for(String street_name:car.getStreets()){
                    if(street_name== value.streetName){
                        value.tripCarScore+=car.getScore()/value.startingCarScore+1;
                        streetHash.put(key, value);
                    }
                }
            }
        }
    }

    protected static class Street {
        private int startIntersection;
        private int endIntersection;
        private String streetName;
        private int time;
        private int startingCarScore = 0;
        private int tripCarScore = 0;

        public int getStartingCarScore() {
            return startingCarScore;
        }

        public void setStartingCarScore(int startingCarScore) {
            this.startingCarScore = startingCarScore;
        }

        public int getTripCarScore() {
            return tripCarScore;
        }

        public void setTripCarScore(int tripCarScore) {
            this.tripCarScore = tripCarScore;
        }

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
