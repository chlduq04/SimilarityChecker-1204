import java.math.BigDecimal;

public class SimilarityChecker {

    public float checkLength(String firstString, String secondString) {
        if (isAnyBlank(firstString, secondString)) return 0;
        int firstLength = firstString.length();
        int secondLength = secondString.length();
        BigDecimal maxLength;
        BigDecimal minLength;
        if (firstLength > secondLength) {
            maxLength = new BigDecimal(firstLength);
            minLength = new BigDecimal(secondLength);
        } else {
            maxLength = new BigDecimal(secondLength);
            minLength = new BigDecimal(firstLength);
        }
        return getScore(maxLength, minLength);
    }

    private static boolean isAnyBlank(String firstString, String secondString) {
        return firstString == null || secondString == null || firstString.isEmpty() || secondString.isEmpty();
    }

    private static float getScore(BigDecimal maxLength, BigDecimal minLength) {
        BigDecimal numerator = maxLength.subtract(minLength); // a - b
        BigDecimal fraction = numerator.divide(minLength, 10, BigDecimal.ROUND_DOWN);
        BigDecimal score = BigDecimal.ONE.subtract(fraction).multiply(new BigDecimal("60"));
        return score.floatValue();
    }
}
