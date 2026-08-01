public class maximumSumCircularSubarray {
    public static int maxSubarray(int[] nums) {
        int currMax = nums[0];
        int maxSum = nums[0];
        int currMin = nums[0];
        int minSum = nums[0];
        int totalSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            totalSum += nums[i];

            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(nums[i], currMin + nums[i]);
            minSum = Math.min(minSum, currMin);
        }

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }

    public static void main(String[] args) {
        int nums[] = { 5, -3, 5 };
        System.out.println(maxSubarray(nums));
    }
}
