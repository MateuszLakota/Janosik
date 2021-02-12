package pl.lakota.janosik;

import lombok.Getter;
import org.apache.log4j.Logger;
import pl.lakota.janosik.entity.Line;
import pl.lakota.janosik.entity.Point;
import pl.lakota.janosik.serialization.Deserializer;
import pl.lakota.janosik.service.Validator;
import pl.lakota.janosik.serialization.Serializer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private static final Logger LOGGER = Logger.getLogger(Reader.class.getName());
    private static final String REGEX_SPLITTER = ";";

    @Getter
    private static final String USERNAME = System.getProperty("user.name");

    public static void main(String[] args) {
        List<Point> points = Reader.getPoints(Point.getPOINTS_INPUT_FILE_PATH());
        List<Line> lines = Reader.getLines(Line.getLINES_INPUT_FILE_PATH(), points);

        List<Integer> validLinesIds = Validator.getValidLinesIds(lines);

        Serializer.serialize(lines, validLinesIds);
        List<Line> deserializedLines = Deserializer.getListOfDeserializedLines(validLinesIds.size());
    }

    private static List<Point> getPoints(File inputFilePath) {
        List<Point> points = new ArrayList<>(0);

        String line;
        String[] splitLine;

        try (FileReader fileReader = new FileReader(inputFilePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null) {
                splitLine = line.split(REGEX_SPLITTER);
                points.add(new Point(Float.parseFloat(splitLine[0]), Float.parseFloat(splitLine[1]),
                        Integer.parseInt(splitLine[2])));
            }
        } catch (IOException exception) {
            LOGGER.error(exception.getMessage(), exception);
        }

        return points;
    }

    private static List<Line> getLines(File inputFilePath, List<Point> points) {
        List<Line> lines = new ArrayList<>(0);
        List<Point> constructorPoints = new ArrayList<>(0);

        String line;
        String[] splitLine;

        try (FileReader fileReader = new FileReader(inputFilePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null) {
                splitLine = line.split(REGEX_SPLITTER);
                int currentLineId = Integer.parseInt(splitLine[0]);
                for (Point point : points) {
                    if (point.getLineId() == currentLineId) {
                        constructorPoints.add(point);
                    }
                }
                lines.add(new Line(Integer.parseInt(splitLine[0]), new ArrayList<>(constructorPoints),
                        Boolean.parseBoolean(splitLine[1])));
                constructorPoints.clear();
            }
        } catch (IOException exception) {
            LOGGER.error(exception.getMessage(), exception);
        }

        return lines;
    }
}
