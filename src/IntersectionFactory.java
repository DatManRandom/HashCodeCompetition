import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IntersectionFactory {
    protected static List<Intersection> intersectionList = new ArrayList<>();

    protected static class Intersection {
        private int id;
        private List<StreetFactory.Street> streetList;
        private int score;

        public Intersection(int id, List<StreetFactory.Street> streetList) {
            this.id = id;
            for (StreetFactory.Street street : streetList) {
                score += street.getStartingCarScore();
            }
            streetList.sort(Comparator.comparingInt(StreetFactory.Street::getStartingCarScore));
            for (StreetFactory.Street street : streetList) {

                street.setLightTime(street.getTripCarScore() + street.getStartingCarScore() / (streetList.size()));

            }
            this.streetList = streetList;
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
