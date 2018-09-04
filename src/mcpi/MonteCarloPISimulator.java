package mcpi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonteCarloPISimulator {

    public static final double MAX = 1.0;
    public static final double MIN = -1.0;

    private final Random random = new Random();

    public List<Point> generateRandomPoints(int count) {
        List<Point> points = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            points.add(new Point(MIN + (MAX - MIN) * random.nextDouble(), MIN + (MAX - MIN) * random.nextDouble()));
        }
        return points;
    }
}
