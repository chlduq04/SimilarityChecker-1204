import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        checkException(similarityChecker, "bbb", "aaa");
        checkException(similarityChecker, "32b", "54bn");
        checkException(similarityChecker, "Dbe", "EEd");
    }

    private static void checkException(SimilarityChecker similarityChecker, String Dbe, String EEd) {
        try {
            similarityChecker.checkSameAlpha(Dbe, EEd);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

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