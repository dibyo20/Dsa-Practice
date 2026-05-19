import java.util.*;

public class findTwoNonOverlappingSubarraysEachWithTargetSum {
    public static int maxSumTwoNoOverlap(int[] nums, int target) {
        int n = nums.length;
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);

        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum > target) {
                sum -= nums[left];
                left++;
            }

            if (sum == target) {
                int len = right - left + 1;

                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, len + best[left - 1]);
                }
                minLen = Math.min(minLen, len);
            }

            best[right] = minLen;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 3 };
        int target = 3;
        System.out.println(maxSumTwoNoOverlap(nums, target));
    }
}
