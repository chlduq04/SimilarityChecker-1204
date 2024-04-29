import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityCheckerTest {
    @Test
    void checkIsSameLength() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        boolean isSameLength = similarityChecker.checkLength("AAA", "BBB");
        assertEquals(true, isSameLength);
    }

    @Test
    void checkIsNotSameLength() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        boolean isNotSameLength = similarityChecker.checkLength("AAA", "BBBC");
        assertEquals(false, isNotSameLength);
    }

    @Test
    void checkNullString() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        boolean isNullString = similarityChecker.checkLength(null, "BBBC");
        assertEquals(false, isNullString);
        isNullString = similarityChecker.checkLength("CCC", null);
        assertEquals(false, isNullString);
        isNullString = similarityChecker.checkLength(null, null);
        assertEquals(false, isNullString);
    }
}