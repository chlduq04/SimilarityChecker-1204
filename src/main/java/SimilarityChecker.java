import java.math.BigDecimal;
import java.util.regex.Pattern;

public class SimilarityChecker {
    public static final int CHECKER_SIZE = 25;
    public static final int CHAR_A_INT_VALUE = 65;
    public static final int MAX_SAME_ALPHA_SCORE = 40;
    public static final int MAX_SAME_LENGTH_SCORE = 60;
    public static final int DEFAULT_COUNT = 0;
    public static final String BIG_ALPHA_REGEX = "^[A-Z]*$";

    boolean[] firstAlphabetChecker;
    boolean[] secondAlphabetChecker;
    int sameCnt;
    int totalCnt;
    String firstString;
    String secondString;
    BigDecimal maxLength;
    BigDecimal minLength;

    public float getTotalScore(String firstString, String secondString) {
        float score = 0;
        score += checkSameAlpha(firstString, secondString);
        score += checkLength(firstString, secondString);
        return score;
    }

    public float checkSameAlpha(String firstString, String secondString) {
        if (isAnyBlank(firstString, secondString)) return 0;
        initSameChecker(firstString, secondString);
        setSameChecker();
        getCountFromChecker();
        return getScoreOfSameAlpha();
    }

    public float checkLength(String firstString, String secondString) {
        if (isAnyBlank(firstString, secondString)) return 0;
        initLengthChecker(firstString, secondString);
        if (isMoreThanTwice()) return 0;
        return getScoreOfLength();
    }

    private static void isNotBigAlpha(String firstString, String secondString) {
        if (!Pattern.matches(BIG_ALPHA_REGEX, firstString) || !Pattern.matches(BIG_ALPHA_REGEX, secondString)) {
            throw new IllegalArgumentException();
        }
    }

    private void initLengthChecker(String firstString, String secondString) {
        int firstLength = firstString.length();
        int secondLength = secondString.length();
        if (firstLength > secondLength) {
            maxLength = new BigDecimal(firstLength);
            minLength = new BigDecimal(secondLength);
        } else {
            maxLength = new BigDecimal(secondLength);
            minLength = new BigDecimal(firstLength);
        }
    }

    private boolean isMoreThanTwice() {
        BigDecimal divisionResult = maxLength.divide(minLength, 10, BigDecimal.ROUND_DOWN);
        return divisionResult.compareTo(new BigDecimal("2")) >= 0;
    }

    private static boolean isAnyBlank(String firstString, String secondString) {
        return firstString == null || secondString == null || firstString.isEmpty() || secondString.isEmpty();
    }

    private void initSameChecker(String firstString, String secondString) {
        isNotBigAlpha(firstString, secondString);
        this.firstString = firstString;
        this.secondString = secondString;
        firstAlphabetChecker = new boolean[CHECKER_SIZE];
        secondAlphabetChecker = new boolean[CHECKER_SIZE];
        sameCnt = DEFAULT_COUNT;
        totalCnt = DEFAULT_COUNT;
    }

    private void setSameChecker() {
        checkFirstAlphabet();
        checkSecondAlphabet();
    }

    private void checkFirstAlphabet() {
        for (int i = 0; i < firstString.length(); i++) {
            int index = firstString.charAt(i) - CHAR_A_INT_VALUE;
            firstAlphabetChecker[index] = true;
        }
    }

    private void checkSecondAlphabet() {
        for (int i = 0; i < secondString.length(); i++) {
            int index = secondString.charAt(i) - CHAR_A_INT_VALUE;
            secondAlphabetChecker[index] = true;
        }
    }

    private void getCountFromChecker() {
        for (int i = 0; i < CHECKER_SIZE; i++) {
            if (firstAlphabetChecker[i] || secondAlphabetChecker[i]) {
                totalCnt++;
                if (firstAlphabetChecker[i] && secondAlphabetChecker[i]) {
                    sameCnt++;
                }
            }
        }
    }

    private float getScoreOfSameAlpha() {
        BigDecimal bigA = new BigDecimal(sameCnt);
        BigDecimal bigB = new BigDecimal(totalCnt);

        BigDecimal divisionResult = bigA.divide(bigB, 10, BigDecimal.ROUND_DOWN); // bigA / bigB
        BigDecimal score = divisionResult.multiply(new BigDecimal(MAX_SAME_ALPHA_SCORE));
        return score.floatValue();
    }

    private float getScoreOfLength() {
        BigDecimal numerator = maxLength.subtract(minLength); // a - b
        BigDecimal fraction = numerator.divide(minLength, 10, BigDecimal.ROUND_DOWN);
        BigDecimal score = BigDecimal.ONE.subtract(fraction).multiply(new BigDecimal(MAX_SAME_LENGTH_SCORE));
        return score.floatValue();
    }
}
