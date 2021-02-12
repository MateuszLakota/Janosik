package pl.lakota.janosik.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.lakota.janosik.Reader;
import pl.lakota.janosik.service.AppProperties;

import java.io.File;
import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
public class Point implements Serializable {
    @Serial
    private static final long serialVersionUID = 2021_02_12L;

    private static final String INPUT_FILE_NAME_AND_FORMAT = "points.csv";
    private static final String PATH = "C:\\Users\\" + AppProperties.getUSERNAME() + "\\Desktop\\Janosik\\" +
            INPUT_FILE_NAME_AND_FORMAT;

    @Getter
    private static final File POINTS_INPUT_FILE_PATH = new File(PATH);

    private final float x;
    private final float y;

    @Getter
    private final transient int lineId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Float.compare(point.x, x) == 0 && Float.compare(point.y, y) == 0 && lineId == point.lineId;
    }
}
