import java.util.ArrayDeque;
import java.util.Deque;

public class shortestSubarrayWithSumAtLeastK {
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            while (!dq.isEmpty() &&
                    prefix[i] - prefix[dq.peekFirst()] >= k) { // Check if the current prefix sum minus the prefix sum
                                                               // at the front of the deque is greater than or equal to
                                                               // k, so that we can update the minimum length of the
                                                               // subarray.

                minLen = Math.min(minLen,
                        i - dq.pollFirst());
            }

            while (!dq.isEmpty() &&
                    prefix[i] <= prefix[dq.peekLast()]) { // Check if the current prefix sum is less than or equal to
                                                          // the prefix sum at the back of the deque, so that we can
                                                          // remove the indices from the back of the deque until we find
                                                          // a prefix sum that is less than the current prefix sum.

                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = { 2, -1, 2 };
        int k = 3;
        System.out.println(shortestSubarray(nums, k));
    }
}
