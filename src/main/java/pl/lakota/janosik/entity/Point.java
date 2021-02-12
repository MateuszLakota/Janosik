package pl.lakota.janosik.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.File;
import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
public class Point implements Serializable {
    @Serial
    private static final long serialVersionUID = 2021_02_12L;
    private static final String path = "C:\\Users\\Mateusz\\Desktop\\Janosik\\points.csv";
    @Getter
    private static final File pointsInputFilePath = new File(path);

    private final float x;
    private final float y;
    @Getter
    private final transient int lineId;
}
