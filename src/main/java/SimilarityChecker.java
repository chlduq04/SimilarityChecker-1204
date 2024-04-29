public class SimilarityChecker {

    public boolean checkLength(String firstString, String secondString) {
        if (firstString == null) {
            return false;
        } else if (secondString == null) {
            return false;
        }
        return firstString.length() == secondString.length();
    }
}
