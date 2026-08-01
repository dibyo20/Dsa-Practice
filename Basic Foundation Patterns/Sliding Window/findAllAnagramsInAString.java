import java.util.*;

public class findAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length())
            return result;

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
                    result.add(left);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
