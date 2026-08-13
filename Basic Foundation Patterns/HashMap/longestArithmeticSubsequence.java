import java.util.*;

public class longestArithmeticSubsequence {
    public static int longestArithSeqLength(int[] nums) {
        @SuppressWarnings("unchecked")
        HashMap<Integer, Integer>[] dp = new HashMap[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap<>();
        }
        int ans = 2;

        for (int j = 0; j < nums.length; j++) {
            for (int i = 0; i < j; i++) {
                int diff = nums[j] - nums[i];
                dp[j].put(diff, dp[i].getOrDefault(diff, 1) + 1);
                ans = Math.max(ans, dp[j].get(diff));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 9, 4, 7, 2, 10 };
        System.out.println(longestArithSeqLength(nums));
    }
}