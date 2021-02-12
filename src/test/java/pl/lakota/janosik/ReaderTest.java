package pl.lakota.janosik;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.lakota.janosik.entity.Line;
import pl.lakota.janosik.entity.Point;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderTest {
    private static final File POINTS_TEST_FILE = new File("src/main/resources/testPoints.csv");
    private static final File LINES_TEST_FILE = new File("src/main/resources/testLines.csv");
    private static final List<Point> TEST_POINTS;

    @Getter
    private static final List<Line> TEST_LINES;

    static {
        TEST_POINTS = new ArrayList<>(6);
        TEST_POINTS.add(0, new Point(2.0f, 3.0f, 0));
        TEST_POINTS.add(1, new Point(5.0f, 3.0f, 0));
        TEST_POINTS.add(2, new Point(7.0f, 1.0f, 1));
        TEST_POINTS.add(3, new Point(0.0f, 0.0f, 1));
        TEST_POINTS.add(4, new Point(2.0f, 2.0f, 2));
        TEST_POINTS.add(5, new Point(3.0f, 6.0f, 2));

        TEST_LINES = Arrays.asList(new Line(0, Arrays.asList(new Point(2.0f, 3.0f, 0),
                new Point(5.0f, 3.0f, 0)), true), new Line(1,
                Arrays.asList(new Point(7.0f, 1.0f, 1), new Point(0.0f, 0.0f, 1)),
                false), new Line(2, Arrays.asList(new Point(2.0f, 2.0f, 2),
                new Point(3.0f, 6.0f, 2)), false));
    }

    @Test
    public void testGetPoints() {
        List<Point> referencePoints = Reader.getPoints(POINTS_TEST_FILE);
        Assertions.assertIterableEquals(referencePoints, TEST_POINTS);
    }

    @Test
    public void testGetLines() {
        List<Line> referenceLines = Reader.getLines(LINES_TEST_FILE, TEST_POINTS);
        Assertions.assertIterableEquals(referenceLines, TEST_LINES);
    }
}
