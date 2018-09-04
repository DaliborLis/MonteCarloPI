package mcpi;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 640;
    private static final int POINT_COUNT = 20000;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Monte Carlo PI");
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        MonteCarloPISimulator simulator = new MonteCarloPISimulator();
        List<Point> points = simulator.generateRandomPoints(POINT_COUNT);

        double insideCircle = points.stream().filter(Point::isInsideCircle).count();
        double pi = 4 * (insideCircle / POINT_COUNT);
        System.out.println(pi);

        drawScene(gc, points);
        Group group = new Group();
        group.getChildren().add(canvas);
        primaryStage.setScene(new Scene(group));
        primaryStage.show();
    }

    private void drawScene(GraphicsContext gc, List<Point> points) {
        gc.strokeOval(0, 0, WIDTH, HEIGHT);
        points.forEach(point -> {
            if (point.isInsideCircle()) {
                gc.setFill(Color.RED);
            } else {
                gc.setFill(Color.GREEN);
            }
            double x = (point.getX() - MonteCarloPISimulator.MIN) * WIDTH / (MonteCarloPISimulator.MAX - MonteCarloPISimulator.MIN);
            double y = (point.getY() - MonteCarloPISimulator.MIN) * HEIGHT / (MonteCarloPISimulator.MAX - MonteCarloPISimulator.MIN);
            gc.fillOval(x - 2, y - 2, 5, 5);
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
