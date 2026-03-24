public class longestCommonPreffix { // Binary Search Approach
    private static boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        // to get the minimum length string
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }

        int low = 1;
        int high = minLen;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isCommonPrefix(strs, mid))
                low = mid + 1; // try for a longer prefix
            else
                high = mid - 1; // try for a shorter prefix
        }

        // (low + high) / 2 gives the final valid prefix length
        return strs[0].substring(0, (low + high) / 2);
    }

    public static void main(String[] args) {
        String[] words = { "flower", "flow", "flight" };
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(words));
    }
}
