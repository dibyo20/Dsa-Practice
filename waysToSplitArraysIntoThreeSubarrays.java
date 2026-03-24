public class waysToSplitArraysIntoThreeSubarrays {
    public static int waysToSplit(int[] nums) {
        int n = nums.length;
        int mod = (int) 1e9 + 7; // This is a common modulus used in competitive programming to prevent integer overflow, i.e. the result can be very large, so we take the result modulo 1e9 + 7 to keep it manageable.
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int result = 0;
        int j = 0, k = 0;

        for (int i = 0; i < n - 2; i++) {
            j = Math.max(j, i + 1);
            while (j < n - 1 && prefix[j] < 2 * prefix[i]) {
                j++;
            }

            k = Math.max(k, j);
            while (k < n - 1 && prefix[k] <= (prefix[n - 1] + prefix[i]) / 2) {
                k++;
            }

            if (j < k) {
                result = (result + (k - j)) % mod; // This 'mod' is used to ensure that the result does not exceed the limits of integer storage, as the number of ways to split can grow very large. By taking the result modulo 1e9 + 7, we can keep it within a manageable range while still providing the correct count of ways to split the array.
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 5, 0};
        System.out.println(waysToSplit(nums));
    }
}
