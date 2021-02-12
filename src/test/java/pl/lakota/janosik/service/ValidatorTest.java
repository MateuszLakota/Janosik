package pl.lakota.janosik.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.lakota.janosik.ReaderTest;

import java.util.Collections;
import java.util.List;

public class ValidatorTest {
    private static final List<Integer> VALID_LINES_IDS;

    static {
        VALID_LINES_IDS = Collections.singletonList(1);
    }

    @Test
    public void testGetValidLinesIds() {
        List<Integer> referenceValidLinesIds = Validator.getValidLinesIds(ReaderTest.getTEST_LINES());
        Assertions.assertIterableEquals(referenceValidLinesIds, referenceValidLinesIds);
    }
}
