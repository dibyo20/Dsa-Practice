public class getEqualSubstringsWithinBudget {
    public static int equalSubstring(String s, String t, int maxCost) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int currentCost = 0;
        int n = s.length();

        while (right < n) {
            int cost = Math.abs(s.charAt(right) - t.charAt(right));
            currentCost += cost;

            while (currentCost > maxCost) {
                currentCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd", "bcdf", 3)); 
        System.out.println(equalSubstring("abcd", "cdef", 3)); 
    }
}
