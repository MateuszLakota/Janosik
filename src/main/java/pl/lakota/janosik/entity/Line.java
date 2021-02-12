package pl.lakota.janosik.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.lakota.janosik.service.AppProperties;

import java.io.File;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class Line implements Serializable {
    @Serial
    private static final long serialVersionUID = 2021_02_12L;

    private static final String INPUT_FILE_NAME_AND_FORMAT = "lines.csv";
    private static final String PATH = "C:\\Users\\" + AppProperties.getUSERNAME() + "\\Desktop\\Janosik\\" +
            INPUT_FILE_NAME_AND_FORMAT;

    @Getter
    private static final File LINES_INPUT_FILE_PATH = new File(PATH);

    @Getter
    private final int id;

    private final List<Point> points;

    @Getter
    private final boolean shouldBeSerialized;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return id == line.id && shouldBeSerialized == line.shouldBeSerialized && points.equals(line.points);
    }
}
