public class SimilarityChecker {

    public boolean checkSameAlpha(String firstString, String secondString) {
        if (isAnyBlank(firstString, secondString)) return false;
        return firstString.equals(secondString);
    }

    private static boolean isAnyBlank(String firstString, String secondString) {
        return firstString == null || secondString == null || firstString.isEmpty() || secondString.isEmpty();
    }
}
