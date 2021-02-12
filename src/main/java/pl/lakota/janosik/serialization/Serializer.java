package pl.lakota.janosik.serialization;

import lombok.Getter;
import org.apache.log4j.Logger;
import pl.lakota.janosik.Reader;
import pl.lakota.janosik.entity.Line;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class Serializer {
    private static final Logger LOGGER = Logger.getLogger(Serializer.class.getName());

    @Getter
    private static final String JSON = ".JSON";

    @Getter
    private static final String XML = ".XML";

    private static final String OUTPUT_FILE_NAME = "Line";

    @Getter
    private static final File SERIALIZATION_PATH = new File("C:\\Users\\" + Reader.getUSERNAME() +
            "\\Desktop\\" + OUTPUT_FILE_NAME);

    public static void serialize(List<Line> lines, List<Integer> validLinesIds, String format) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(SERIALIZATION_PATH + format);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            for (Line line : lines) {
                if (validLinesIds.contains(line.getId())) {
                    objectOutputStream.writeObject(line);
                    objectOutputStream.flush();
                }
            }
        } catch (IOException exception) {
            LOGGER.error(exception.getMessage(), exception);
        }
    }
}
