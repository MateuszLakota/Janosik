package pl.lakota.janosik.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.lakota.janosik.Reader;

import java.io.File;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
public class Line implements Serializable {
    @Serial
    private static final long serialVersionUID = 2021_02_12L;

    private static final String INPUT_FILE_NAME_Format = "lines.csv";
    private static final String PATH = "C:\\Users\\" + Reader.getUSERNAME() + "\\Desktop\\Janosik\\" +
            INPUT_FILE_NAME_Format;

    @Getter
    private static final File LINES_INPUT_FILE_PATH = new File(PATH);

    @Getter
    private final int id;

    private final List<Point> points;

    @Getter
    private final boolean shouldBeSerialized;
}
