package pl.lakota.janosik.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.File;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
public class Line implements Serializable {
    @Serial
    private static final long serialVersionUID = 2021_02_12L;
    private static final String path = "C:\\Users\\Mateusz\\Desktop\\Janosik\\lines.csv";
    @Getter
    private static final File linesInputFilePath = new File(path);

    @Getter
    private final int id;
    private final List<Point> points;
    @Getter
    private final boolean shouldBeSerialized;
}
