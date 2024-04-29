import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityCheckerTest {
    @Test
    void checkIsSameLength() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        boolean isSameLength = similarityChecker.checkLength("AAA", "BBB");
        assertEquals(true, isSameLength);
    }
}