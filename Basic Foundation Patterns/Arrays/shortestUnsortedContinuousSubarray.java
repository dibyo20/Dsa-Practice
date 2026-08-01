public class shortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int right = -1;
        for (int i = 1; i < n; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }
        }

        int min = nums[n - 1];
        int left = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > min) {
                left = i;
            } else {
                min = nums[i];
            }
        }

        if (right == -1) {
            return 0;
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 6, 4, 8, 10, 9, 15 };
        System.out.println(findUnsortedSubarray(nums));
    }
}
