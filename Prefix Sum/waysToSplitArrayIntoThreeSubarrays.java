public class waysToSplitArrayIntoThreeSubarrays {
    public static int waysToSplit(int[] nums) {
        int n = nums.length;
        int mod = (int) 1e9 + 7;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        int result = 0;
        int j = 0, k = 0;
        for (int i = 0; i < n - 2; i++) {
            j = Math.max(j, i + 1);
            while (j < n - 1 && prefix[j] < 2 * prefix[i]) { // Here we are checking if the sum of the first subarray is less than the sum of the second subarray by the formula 2 * prefix[i] because the sum of the first subarray is prefix[i] and the sum of the second subarray is prefix[j] - prefix[i], so we can rearrange the formula to get prefix[j] < 2 * prefix[i].
                j++;
            }
            k = Math.max(k, j); // Here we are checking if the sum of the second subarray is less than the sum of the third subarray by the formula (prefix[n - 1] + prefix[i]) / 2 because the sum of the second subarray is prefix[j] - prefix[i] and the sum of the third subarray is prefix[n - 1] - prefix[j], so we can rearrange the formula to get prefix[j] < (prefix[n - 1] + prefix[i]) / 2.
            while (k < n - 1 && prefix[k] <= (prefix[n - 1] + prefix[i]) / 2) { // Here we are checking if the sum of the second subarray is less than or equal to the sum of the third subarray by the formula (prefix[n - 1] + prefix[i]) / 2 because the sum of the second subarray is prefix[j] - prefix[i] and the sum of the third subarray is prefix[n - 1] - prefix[j], so we can rearrange the formula to get prefix[j] <= (prefix[n - 1] + prefix[i]) / 2.
                k++;
            }
            if (j < k) {
                result = (result + (k - j)) % mod; // Here we are doing mod, because the result can be very large, so we need to take the mod of the result to avoid overflow.
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 2, 5, 0 };
        System.out.println(waysToSplit(nums));
    }
}
