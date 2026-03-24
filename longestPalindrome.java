import java.util.*;

public class longestPalindrome {
    public static int longestPalindrome(String s) { // TC: O(n) SC: O(1), It is most optimal solution.
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        int length = 0;
        boolean oddFound = false;
        for (int f : freq) {
            length += (f / 2) * 2;

            if (f % 2 == 1) {
                oddFound = true;
            }
        }
        if (oddFound)
            length += 1;

        return length;
    }

    public static int longestPalindromeHashset(String s) { // TC: O(n) SC: O(1), It is less optimal solution than above one, because in worst case it can take O(n) space.
        HashSet<Character> set = new HashSet<>();
        int length = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                length += 2;
            } else {
                set.add(c);
            }
        }
        if (!set.isEmpty()) {
            length += 1;
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindromeHashset(s));
    }
}
