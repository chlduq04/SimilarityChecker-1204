import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class SimilarityCheckerTest {

    @Test
    void checkIsSameAlpha() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        assertEquals(40, similarityChecker.checkSameAlpha("ASD", "DSA"));
    }

    @Test
    void checkIsNotSameAlpha() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        assertEquals(0, similarityChecker.checkSameAlpha("A", "BB"));
    }

    @Test
    void checkIsNullOrEmptyAlpha() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        assertEquals(0, similarityChecker.checkSameAlpha(null, "AAA"));
        assertEquals(0, similarityChecker.checkSameAlpha("BAA", null));
        assertEquals(0, similarityChecker.checkSameAlpha(null, null));
        assertEquals(0, similarityChecker.checkSameAlpha("", "AAA"));
        assertEquals(0, similarityChecker.checkSameAlpha("BAA", ""));
        assertEquals(0, similarityChecker.checkSameAlpha("", ""));
    }

    @Test
    void checkIsNotBigAlpha() {
        SimilarityChecker similarityChecker = new SimilarityChecker();
        try {
            similarityChecker.checkSameAlpha("bbb", "aaa");
            fail();
        } catch (IllegalArgumentException e) {}
        try {
            similarityChecker.checkSameAlpha("32b", "54bn");
            fail();
        } catch (IllegalArgumentException e) {}
        try {
            similarityChecker.checkSameAlpha("Dbe", "EEd");
            fail();
        } catch (IllegalArgumentException e) {}
    }
}