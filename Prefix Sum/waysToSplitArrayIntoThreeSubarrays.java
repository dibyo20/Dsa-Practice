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
            while (j < n - 1 && prefix[j] < 2 * prefix[i]) {
                j++;
            }
            k = Math.max(k, j);
            while (k < n - 1 && prefix[k] <= (prefix[n - 1] + prefix[i]) / 2) {
                k++;
            }
            if (j < k) {
                result = (result + (k - j)) % mod;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 2, 5, 0 };
        System.out.println(waysToSplit(nums));
    }
}
