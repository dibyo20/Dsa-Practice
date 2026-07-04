public class longestSubstringWithAtLeastKRepeatingCharacters {
    public static int longestSubstring(String s, int k) {
        int ans = 0;
        int n = s.length();

        for (int targetUnique = 1; targetUnique <= 26; targetUnique++) {
            int[] freq = new int[26];
            int left = 0, right = 0;
            int unique = 0;
            int countAtLeastK = 0;

            while (right < n) {
                int idx = s.charAt(right) - 'a';

                if (freq[idx] == 0)
                    unique++;

                freq[idx]++;

                if (freq[idx] == k)
                    countAtLeastK++;

                right++;

                while (unique > targetUnique) {
                    int leftIdx = s.charAt(left) - 'a';

                    if (freq[leftIdx] == k)
                        countAtLeastK--;

                    freq[leftIdx]--;

                    if (freq[leftIdx] == 0)
                        unique--;

                    left++;
                }

                if (unique == targetUnique && unique == countAtLeastK)
                    ans = Math.max(ans, right - left);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("ababbc", 2));
    }
}
