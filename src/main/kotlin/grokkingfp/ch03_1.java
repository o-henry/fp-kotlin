package grokkingfp;

import java.util.ArrayList;
import java.util.List;

public class ch03_1 {
    static double totalTime(List<Double> lapTimes) {
        var lap = new ArrayList<>(lapTimes);
        lap.remove(0);

        double sum = 0;
        for (double x : lap) {
            sum += x;
        }
        return sum;
    }

    static double avgTime(List<Double> lapTimes) {
        double time = totalTime(lapTimes);
        List<Double> withoutWarmUp = new ArrayList<>(lapTimes);
        withoutWarmUp.remove(0); // remove warm-up lap
        int laps = withoutWarmUp.size();
        return time / laps;
    }

    public static void main(String[] args) {
        ArrayList lapTimes = new ArrayList<>();
        lapTimes.add(31.0); // warm-up lap
        lapTimes.add(20.9);
        lapTimes.add(21.1);
        lapTimes.add(21.3);
        System.out.printf("Total: %.1fs\n", totalTime(lapTimes));
        System.out.printf("Avg: %.1fs", avgTime(lapTimes));
    }
}
