package pl.lakota.janosik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.lakota.janosik.entity.Point;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ReaderTest {
    private static File testFile = new File("src/main/resources/test.csv");

    @Test
    public void testGetPoints() {
        List<Point> testPoints = Arrays.asList(new Point(1.0f, 6.0f, 0),
                new Point(2.0f, 3.0f, 0));
        List<Point> referencePoints = Reader.getPoints(testFile);
        Assertions.assertIterableEquals(testPoints, referencePoints);
    }

    @Test
    public void testGtLines() {

    }
}
