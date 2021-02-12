package pl.lakota.janosik.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.lakota.janosik.ReaderTest;

import java.util.ArrayList;
import java.util.List;

public class ValidatorTest {
    private static final List<Integer> VALID_LINES_IDS;

    static {
        VALID_LINES_IDS = new ArrayList<>(1);
        VALID_LINES_IDS.add(0, 0);
    }

    @Test
    public void testGetValidLinesIds() {
        List<Integer> referenceValidLinesIds = Validator.getValidLinesIds(ReaderTest.getTEST_LINES());
        Assertions.assertIterableEquals(referenceValidLinesIds, VALID_LINES_IDS);
    }
}
