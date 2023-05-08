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
        int laps = lapTimes.size();
        return time / laps;
    }
}
