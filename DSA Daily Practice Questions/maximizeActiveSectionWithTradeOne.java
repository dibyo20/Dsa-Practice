public class maximizeActiveSectionWithTradeOne {
    public static int maxActiveSectionsAfterTrade(String s) {
        String t = "1" + s + "1";
        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                totalOnes++;
            }
        }

        int leftZeroes = 0;
        int bestGain = 0;
        int i = 0;

        while (i < t.length()) {
            int currOnes = 0;
            while (i < t.length() && t.charAt(i) == '1') {
                currOnes++;
                i++;
            }

            int rightZeroes = 0;
            while (i < t.length() && t.charAt(i) == '0') {
                rightZeroes++;
                i++;
            }

            if (leftZeroes > 0 && currOnes > 0 && rightZeroes > 0) {
                bestGain = Math.max(bestGain, leftZeroes + rightZeroes);
            }

            leftZeroes = rightZeroes;
        }
        return totalOnes + bestGain;
    }

    public static void main(String[] args) {
        System.out.println(maxActiveSectionsAfterTrade("01"));
        System.out.println(maxActiveSectionsAfterTrade("0100"));
        System.out.println(maxActiveSectionsAfterTrade("1000100"));
        System.out.println(maxActiveSectionsAfterTrade("01010"));
    }
}