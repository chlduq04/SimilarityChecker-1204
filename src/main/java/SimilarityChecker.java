import java.math.BigDecimal;

public class SimilarityChecker {
    public static final int CHECKER_SIZE = 25;
    public static final int CHAR_A_INT_VALUE = 65;
    public static final int MAX_SCORE = 40;
    boolean[] firstAlphaChecker;
    boolean[] secondAlphaChecker;
    int sameCnt;
    int totalCnt;
    public float checkSameAlpha(String firstString, String secondString) {
        if (isAnyBlank(firstString, secondString)) return 0;
        initChecker();
        setChecker(firstString, secondString);
        calAlphaCount();
        return getScore();
    }

    private void calAlphaCount() {
        for (int i = 0; i < 25; i++) {
            if (firstAlphaChecker[i] || secondAlphaChecker[i]) {
                if (firstAlphaChecker[i] && secondAlphaChecker[i]) {
                    sameCnt++;
                }
                totalCnt++;
            }
        }
    }

    private void initChecker() {
        firstAlphaChecker = new boolean[CHECKER_SIZE];
        secondAlphaChecker = new boolean[CHECKER_SIZE];
        sameCnt = 0;
        totalCnt = 0;
    }

    private void setChecker(String firstString, String secondString) {
        for (int i = 0; i < firstString.length(); i++) {
            int index = firstString.charAt(i) - CHAR_A_INT_VALUE;
            firstAlphaChecker[index] = true;
        }
        for (int i = 0; i < secondString.length(); i++) {
            int index = secondString.charAt(i) - CHAR_A_INT_VALUE;
            secondAlphaChecker[index] = true;
        }
    }

    private float getScore() {
        BigDecimal bigA = new BigDecimal(sameCnt);
        BigDecimal bigB = new BigDecimal(totalCnt);

        BigDecimal divisionResult = bigA.divide(bigB, 10, BigDecimal.ROUND_DOWN); // bigA / bigB
        BigDecimal finalResult = divisionResult.multiply(new BigDecimal(MAX_SCORE));
        return finalResult.floatValue();
    }

    private static boolean isAnyBlank(String firstString, String secondString) {
        return firstString == null || secondString == null || firstString.isEmpty() || secondString.isEmpty();
    }
}
