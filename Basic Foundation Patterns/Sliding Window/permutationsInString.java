import java.util.Arrays;

public class permutationsInString {
    public static boolean findPermutations(String s, String p) {
        if (p.length() > s.length())
            return false;

        int[] pFreq = new int[26];
        int windowFreq[] = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            windowFreq[s.charAt(right) - 'a']++;

            if (right - left + 1 > p.length()) {
                windowFreq[s.charAt(left) - 'a']--;
                left++;
            }

            if (right - left + 1 == p.length()) {
                if (Arrays.equals(windowFreq, pFreq)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findPermutations("eidbaoo", "ab"));
    }
}
