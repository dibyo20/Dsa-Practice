import java.util.Arrays;

public class runningSumOf1DArray {
    public static int[] runningSum(int[] nums) {
        int runsum[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            runsum[i] = nums[i] + (i > 0 ? runsum[i - 1] : 0);
        }
        return runsum;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(runningSum(nums)));
    }
}
