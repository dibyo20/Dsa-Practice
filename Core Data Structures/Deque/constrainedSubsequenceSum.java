import java.util.Deque;
import java.util.LinkedList;

public class constrainedSubsequenceSum {
    public static int maxSubsequenceSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(0);
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            while (deque.peekFirst() < i - k) {
                deque.pollFirst();
            }
            dp[i] = nums[i] + Math.max(0, dp[deque.peekFirst()]);

            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 2, -10, 5, 20 };
        int k = 2;
        System.out.println(maxSubsequenceSum(nums, k));
    }
}
