import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityCheckerTest {
    @Test
    void checkIsSameLength() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        assertEquals(60, similarityChecker.checkLength("AAA", "BBB"));
    }

    @Test
    void checkIsNotSameLength() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        assertEquals(40, similarityChecker.checkLength("AAA", "BBBC"));
        assertEquals(40, similarityChecker.checkLength("AAAC", "BBB"));
    }

    @Test
    void checkNullString() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        assertEquals(0, similarityChecker.checkLength(null, "BBBC"));
        assertEquals(0, similarityChecker.checkLength("CCC", null));
        assertEquals(0, similarityChecker.checkLength(null, null));
    }

    @Test
    void checkEmptyString() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        assertEquals(0, similarityChecker.checkLength("", "BBBC"));
        assertEquals(0, similarityChecker.checkLength("CCC", ""));
        assertEquals(0, similarityChecker.checkLength("", ""));
    }

    @Test
    void checkLengthMoreThanTwiceString() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        assertEquals(0, similarityChecker.checkLength("B", "BBBC"));
        assertEquals(0, similarityChecker.checkLength("BA", "BBBCAAA"));
    }
}