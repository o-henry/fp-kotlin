package grokkingfp;

import java.util.ArrayList;
import java.util.List;

public class ch03 {
    public static void main(String[] args) {
        List<String> planA = new ArrayList<>();
        planA.add("Paris");
        planA.add("Berlin");
        planA.add("Krakov");
        System.out.println("Plan A: " + planA);

        List<String> planB = replan(planA, "Vienna", "Krakov");
        System.out.println("Plan B" + planB);
    }

    private static List<String> replan(List<String> plan, String newCity, String beforeCity) {
        int newCityIndex = plan.indexOf(beforeCity);
        List<String> replanned = new ArrayList<>(plan);
        replanned.add(newCityIndex, newCity);
        return replanned;
    }
}
