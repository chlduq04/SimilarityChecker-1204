import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityCheckerTest {

    @Test
    void checkIsSameAlpha() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        assertEquals(true, similarityChecker.checkSameAlpha("AAA", "AAA"));
    }

    @Test
    void checkIsNotSameAlpha() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        assertEquals(false, similarityChecker.checkSameAlpha("BAA", "AAA"));
    }

    @Test
    void checkIsNullOrEmptyAlpha() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        assertEquals(false, similarityChecker.checkSameAlpha(null, "AAA"));
        assertEquals(false, similarityChecker.checkSameAlpha("BAA", "AAA"));
        assertEquals(false, similarityChecker.checkSameAlpha(null, "AAA"));
        assertEquals(false, similarityChecker.checkSameAlpha("", "AAA"));
        assertEquals(false, similarityChecker.checkSameAlpha("BAA", ""));
        assertEquals(false, similarityChecker.checkSameAlpha("", ""));
    }

}