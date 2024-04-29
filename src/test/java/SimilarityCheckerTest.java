import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityCheckerTest {
    @Test
    void checkIsSameLength() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        assertEquals(true, similarityChecker.checkLength("AAA", "BBB"));
    }

    @Test
    void checkIsNotSameLength() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        assertEquals(false, similarityChecker.checkLength("AAA", "BBBC"));
    }

    @Test
    void checkNullString() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        assertEquals(false, similarityChecker.checkLength(null, "BBBC"));
        assertEquals(false, similarityChecker.checkLength("CCC", null));
        assertEquals(false, similarityChecker.checkLength(null, null));
    }
}