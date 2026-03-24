public class maxAverageSubarray2 {
    public static double findMaxAverage(int[] nums, int k) {
        double low = Integer.MAX_VALUE;
        double high = Integer.MIN_VALUE;
        for (int num : nums) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }

        while (high - low > 1e-5) { // This '1e-5' is a small threshold to determine when to stop the binary search
                                    // i.e. when the difference between high and low is less than this threshold, we
                                    // can consider that we have found the maximum average with sufficient
                                    // precision.
            double mid = low + (high - low) / 2;
            if (canFind(nums, k, mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static boolean canFind(int[] nums, int k, double mid) {
        double sum = 0;
        double prevSum = 0;
        double minPrev = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i] - mid;
        }
        if (sum >= 0)
            return true;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - mid;
            prevSum += nums[i - k] - mid;
            minPrev = Math.min(minPrev, prevSum);
            if (sum - minPrev >= 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 12, -5, -6, 50, 3 };
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }
}
