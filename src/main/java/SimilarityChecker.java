import java.math.BigDecimal;

public class SimilarityChecker {

    public float checkSameAlpha(String firstString, String secondString) {
        if (isAnyBlank(firstString, secondString)) return 0;
        boolean[] firstAlphaChecker = new boolean[25];
        boolean[] secondAlphaChecker = new boolean[25];
        for (int i = 0; i < firstString.length(); i++) {
            int index = (int) firstString.charAt(i) - (int) 'A';
            firstAlphaChecker[index] = true;
        }
        for (int i = 0; i < secondString.length(); i++) {
            int index = (int) secondString.charAt(i) - (int)'A';
            secondAlphaChecker[index] = true;
        }
        int sameCnt = 0;
        int totalCnt = 0;
        for (int i = 0; i < 25; i++) {
            if (firstAlphaChecker[i] || secondAlphaChecker[i]) {
                if (firstAlphaChecker[i] && secondAlphaChecker[i]) {
                    sameCnt++;
                }
                totalCnt++;
            }
        }
        BigDecimal bigA = new BigDecimal(sameCnt);
        BigDecimal bigB = new BigDecimal(totalCnt);

        BigDecimal divisionResult = bigA.divide(bigB, 10, BigDecimal.ROUND_DOWN); // bigA / bigB
        BigDecimal finalResult = divisionResult.multiply(new BigDecimal("40"));
        return finalResult.floatValue();
    }

    private static boolean isAnyBlank(String firstString, String secondString) {
        return firstString == null || secondString == null || firstString.isEmpty() || secondString.isEmpty();
    }
}
