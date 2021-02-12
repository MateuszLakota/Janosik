package pl.lakota.janosik.serialization;

import org.apache.log4j.Logger;
import pl.lakota.janosik.entity.Line;
import pl.lakota.janosik.service.AppProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Deserializer {
    private static final Logger LOGGER = Logger.getLogger(Deserializer.class.getName());

    public static List<Line> getListOfDeserializedLines(int numberOfSerializedObjects) {
        List<Line> deserializedLines = new ArrayList<>(0);
        Line line;
        String format = AppProperties.getPropertiesValue("typeOfAPI").equals("REST") ? Serializer.getJSON() :
                Serializer.getXML();

        try (FileInputStream fileInputStream = new FileInputStream(Serializer.getSERIALIZATION_PATH() + format);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            for (int i = 0; i < numberOfSerializedObjects; i++) {
                line = (Line) objectInputStream.readObject();
                deserializedLines.add(line);
            }
        } catch (IOException | ClassNotFoundException exception) {
            LOGGER.error(exception.getMessage(), exception);
        }

        return deserializedLines;
    }
}
