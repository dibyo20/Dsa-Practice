public class maximumScoreAfterSplittingAString {
    public static int maxScore(String s) {
        int rightOnes = 0;
        int leftZeros = 0;
        int maxScore = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                rightOnes++;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }
            maxScore = Math.max(maxScore, leftZeros + rightOnes);
        }
        return maxScore;
    }

    public static void main(String[] args) {
        String s = "011101";
        System.out.println(maxScore(s));
    }
}
