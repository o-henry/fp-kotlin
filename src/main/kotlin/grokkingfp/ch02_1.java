package grokkingfp;

import java.util.ArrayList;
import java.util.List;

public class ch02_1 {
    static class TipCalculator {
        private final List<String> names = new ArrayList<>();

        public List<String> addPerson(List<String> names, String name) {
            // 함수 block 관점에서 {} names는 외부 컨텍스트에 존재하므로, 매개변수를 통해 입력을 받아야 한다.
            List<String> updated = new ArrayList<>(names);
            updated.add(name);
            return updated;
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


