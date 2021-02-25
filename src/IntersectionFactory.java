import java.util.*;

public class IntersectionFactory {
    protected static List<Intersection> intersectionList = new ArrayList<>();

    protected static void sortinintersection() {
        intersectionList.sort(Comparator.comparingInt(Intersection::getScore));
    }
    public void setStreetTime() {

    }

    protected static class Intersection {
        private int id;
        private List<StreetFactory.Street> streetList;
        private int score;

        public Intersection(int id) {
            this.id = id;
        }

        public Intersection addStreet(StreetFactory.Street street) {
            if (!streetList.contains(street))
                streetList.add(street);
            score += street.getStartingCarScore();
            return this;
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
