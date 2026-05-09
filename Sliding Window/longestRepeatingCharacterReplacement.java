public class longestRepeatingCharacterReplacement {
    public static int replacechar(String s, int k) {
        int freq[] = new int[26];
        int left = 0;
        int maxlen = 0;
        int maxFreq = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;

            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(replacechar(s, k));
    }
}
