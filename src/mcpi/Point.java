package mcpi;

public class Point {

    private final double x;
    private final double y;
    private final boolean insideCircle;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        this.insideCircle = x * x + y * y <= 1.0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isInsideCircle() {
        return insideCircle;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
