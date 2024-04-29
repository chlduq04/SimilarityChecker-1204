public class SimilarityChecker {

    public boolean checkLength(String firstString, String secondString) {
        if (firstString == null || secondString == null) return false;
        return firstString.length() == secondString.length();
    }
}
