public class findTheSmallestDivisorGivenAThreshold {
    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        for (int num : nums) {
            high = Math.max(high, num);
        }

        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(nums, threshold, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isValid(int nums[], int threshold, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor; // This a trick to calculate the ceiling of num/divisor without using
                                                  // floating-point division. It adds divisor - 1 to num before
                                                  // dividing, which effectively rounds up the division result.
        }
        return sum <= threshold;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 5, 9 };
        int threshold = 6;
        System.out.println(smallestDivisor(nums, threshold));
    }
}
