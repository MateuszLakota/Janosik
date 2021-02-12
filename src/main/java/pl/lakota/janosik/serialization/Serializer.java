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
    private static final String JSON = ".JSON";
    private static final String XML = ".XML";

    @Getter
    private static final File SERIALIZATION_PATH = new File("C:\\Users\\" + Reader.getUSERNAME() +
            "\\Desktop\\Line" + XML);

    public static void serialize(List<Line> lines, List<Integer> validLinesIds) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(SERIALIZATION_PATH);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            for (Line line : lines) {
                if (validLinesIds.contains(line.getId())) {
                    objectOutputStream.writeObject(line);
                    objectOutputStream.flush();
                }
            }
        } catch (IOException exception) {
            LOGGER.error(exception.getMessage());
        }
    }
}
