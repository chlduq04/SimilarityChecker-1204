public class SimilarityChecker {

    public boolean checkSameAlpha(String firstString, String secondString) {
        if (firstString == null || secondString == null || firstString.isEmpty() || secondString.isEmpty()) return false;
        return firstString.equals(secondString);
    }
}
