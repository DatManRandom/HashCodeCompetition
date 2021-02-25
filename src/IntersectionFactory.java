import java.util.HashMap;
import java.util.List;

public class IntersectionFactory {
    protected static HashMap<Integer, Intersection> intersectionHashMap = new HashMap<>();

    protected class Intersection {
        private int id;
        private List<StreetFactory.Street> streetList;
        private int score;

        public Intersection(int id) {
            this.id = id;
        }

        public void addStreet(StreetFactory.Street street) {
            streetList.add(street);
            score += street.getStartingCarScore();
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getId() {
            return id;
        }

        public List<StreetFactory.Street> getStreetList() {
            return streetList;
        }

        public int getScore() {
            return score;
        }
    }
}
