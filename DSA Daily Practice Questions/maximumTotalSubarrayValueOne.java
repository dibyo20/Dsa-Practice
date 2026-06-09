public class maximumTotalSubarrayValueOne {
    public static long maxTotalSum(int[] nums, int k) {
        int globalMax = Integer.MIN_VALUE;
        int globalMin = Integer.MAX_VALUE;

        for (int num : nums) {
            globalMax = Math.max(globalMax, num);
            globalMin = Math.min(globalMin, num);
        }

        long diff = (long) globalMax - globalMin;
        return diff * k;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int k = 2;
        System.out.println(maxTotalSum(nums, k));
    }
}
