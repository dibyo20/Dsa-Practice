import java.util.*;

public class continuousSubarrays {
    public static long subarrays(int[] nums) {
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        int left = 0;
        long ans = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > 2) {
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 4, 2, 4 };
        System.out.println(subarrays(nums));
    }
}
