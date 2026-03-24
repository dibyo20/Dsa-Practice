public class minimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int left = 0;
        int right = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            if (map[r] > 0) {
                count--;
            }

            map[r]--;
            right++;
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                char l = s.charAt(left);
                map[l]++;
                if (map[l] > 0) {
                    count++;
                }
                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE)
            return "";
        
        return s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
