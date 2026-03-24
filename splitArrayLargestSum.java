public class splitArrayLargestSum {
    public static int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        for (int n : nums) {
            low = Math.max(low, n);
            high += n;
        }
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canSplit(nums, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean canSplit(int nums[], int k, int mid) { // This helper function is the main logic of the
                                                                  // problem. It checks if we can split the array into
                                                                  // at most k subarrays such that the largest sum of
                                                                  // any subarray is less than or equal to mid.
        int sum = 0;
        int count = 1;
        for (int num : nums) {
            sum += num;
            if (sum > mid) {
                count++;
                sum = num;
            }
        }
        return count <= k;
    }

    public static void main(String[] args) {
        int nums[] = { 7, 2, 5, 10, 8 };
        int k = 2;
        System.out.println(splitArray(nums, k));
    }
}
