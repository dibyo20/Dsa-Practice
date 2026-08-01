public class longestPalindromeSubstring {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {

            int len1 = expandAroundCenter(s, i, i); // Check for odd length palindrome
            int len2 = expandAroundCenter(s, i, i + 1); // Check for even length palindrome

            int maxLen = Math.max(len1, len2); // Take max length

            if (maxLen > end - start) { // This condition checks if the current palindrome is longer than the previously
                                        // recorded longest palindrome.
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";
        System.out.println("Input: " + s1 + " → Output: " + longestPalindrome(s1));
        System.out.println("Input: " + s2 + " → Output: " + longestPalindrome(s2));
    }
}
