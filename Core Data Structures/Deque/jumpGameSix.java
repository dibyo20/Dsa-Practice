import java.util.*;

public class jumpGameSix {
    public static int minResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(0);
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            while (deque.peekFirst() < i - k) {
                deque.pollFirst();
            }
            dp[i] = nums[i] + dp[deque.peekFirst()];

            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, -2, 4, -7, 3};
        int k = 2;
        System.out.println(minResult(nums, k));
    }
}
