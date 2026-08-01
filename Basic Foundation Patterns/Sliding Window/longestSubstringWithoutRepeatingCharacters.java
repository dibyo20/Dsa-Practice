import java.util.*;

public class longestSubstringWithoutRepeatingCharacters {
    public static int maxlengthOfSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxlen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(maxlengthOfSubstring(s));
    }
}
