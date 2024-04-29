import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimilarityCheckerTest {

    @Test
    void checkIsSameAlpha() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        boolean isSame = similarityChecker.checkSameAlpha("AAA", "AAA");
        assertEquals(true, isSame);
    }

    @Test
    void checkIsNotSameAlpha() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        boolean isSame = similarityChecker.checkSameAlpha("BAA", "AAA");
        assertEquals(false, isSame);
    }
}