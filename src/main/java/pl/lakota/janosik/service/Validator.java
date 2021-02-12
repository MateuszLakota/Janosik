package pl.lakota.janosik.service;

import pl.lakota.janosik.entity.Line;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static List<Integer> getValidLinesIds(List<Line> lines) {
        List<Integer> validLinesIds = new ArrayList<>(0);

        for (Line line : lines) {
            if (line.isShouldBeSerialized()) {
                int id = line.getId();
                validLinesIds.add(id);
            }
        }

        return validLinesIds;
    }
}
