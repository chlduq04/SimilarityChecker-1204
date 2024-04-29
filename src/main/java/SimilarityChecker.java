import java.math.BigDecimal;
import java.util.regex.Pattern;

public class SimilarityChecker {
    public static final int CHECKER_SIZE = 25;
    public static final int CHAR_A_INT_VALUE = 65;
    public static final int MAX_SCORE = 40;
    public static final int DEFAULT_COUNT = 0;

    boolean[] firstAlphabetChecker;
    boolean[] secondAlphabetChecker;
    int sameCnt;
    int totalCnt;
    String firstString;
    String secondString;

    public float checkSameAlpha(String firstString, String secondString) {
        if (isAnyBlank(firstString, secondString)) return 0;
        String regex = "^[A-Z]*$";
        boolean isFirstBitAlph = Pattern.matches(regex, firstString);
        boolean isSecondBitAlph = Pattern.matches(regex, secondString);
        if (!isFirstBitAlph || !isSecondBitAlph) {
            throw new IllegalArgumentException();
        }
        initChecker(firstString, secondString);
        setChecker();
        calAlphaCount();
        return getScore();
    }

    private static boolean isAnyBlank(String firstString, String secondString) {
        return firstString == null || secondString == null || firstString.isEmpty() || secondString.isEmpty();
    }

    private void initChecker(String firstString, String secondString) {
        this.firstString = firstString;
        this.secondString = secondString;
        firstAlphabetChecker = new boolean[CHECKER_SIZE];
        secondAlphabetChecker = new boolean[CHECKER_SIZE];
        sameCnt = DEFAULT_COUNT;
        totalCnt = DEFAULT_COUNT;
    }

    private void setChecker() {
        checkAlphabet(firstString, firstAlphabetChecker);
        checkAlphabet(secondString, secondAlphabetChecker);
    }

    private void checkAlphabet(String alphabet, boolean[] checker) {
        for (int i = 0; i < alphabet.length(); i++) {
            int index = alphabet.charAt(i) - CHAR_A_INT_VALUE;
            checker[index] = true;
        }
    }

    private void calAlphaCount() {
        for (int i = 0; i < 25; i++) {
            if (firstAlphabetChecker[i] || secondAlphabetChecker[i]) {
                if (firstAlphabetChecker[i] && secondAlphabetChecker[i]) {
                    sameCnt++;
                }
                totalCnt++;
            }
        }
    }

    private float getScore() {
        BigDecimal bigA = new BigDecimal(sameCnt);
        BigDecimal bigB = new BigDecimal(totalCnt);

        BigDecimal divisionResult = bigA.divide(bigB, 10, BigDecimal.ROUND_DOWN); // bigA / bigB
        BigDecimal finalResult = divisionResult.multiply(new BigDecimal(MAX_SCORE));
        return finalResult.floatValue();
    }
}
