public class longestPalindrome {
    public static int maxlenPalindrome(String s) {
        int freq[] = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int length = 0;
        boolean oddFound = false;

        for (int f : freq) {
            length += f / 2 * 2;

            if (f % 2 == 1) {
                oddFound = true;
            }
        }

        if (oddFound) {
            length += 1;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(maxlenPalindrome("abccccdd"));
    }
}
