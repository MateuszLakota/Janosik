package pl.lakota.janosik.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.lakota.janosik.Reader;

import java.io.File;
import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
public class Point implements Serializable {
    @Serial
    private static final long serialVersionUID = 2021_02_12L;

    private static final String PATH = "C:\\Users\\" + Reader.getUSERNAME() + "\\Desktop\\Janosik\\points.csv";

    @Getter
    private static final File POINTS_INPUT_FILE_PATH = new File(PATH);

    private final float x;
    private final float y;

    @Getter
    private final transient int lineId;
}
