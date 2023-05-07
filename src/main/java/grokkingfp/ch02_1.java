package grokkingfp;

import java.util.ArrayList;
import java.util.List;

public class ch02_1 {
    static class TipCalculator {
        private List<String> names = new ArrayList<>();

        public List<String> addPerson(List<String> names, String name) {
            List<String> updated = new ArrayList<>(names);
            updated.add(name);
            return updated;
        }

        public List<String> getNames() {
            return names;
        }

        public static int getTipPercentage(List<String> names) {
            if (names.size() > 5) {
                return 20;
            } else if (names.size() > 0) {
                return 10;
            }
            return 0;
        }
    }
}
