import java.util.Arrays;

public class leftAndRightSumDiffrences {
    public static int[] leftRightDifference(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum -= nums[i];
            int current = nums[i];
            nums[i] = Math.abs(leftSum - totalSum);
            leftSum += current;
        }
        return nums;
    }

    public static void main(String[] args) {
        int nums[] = { 10, 4, 8, 3 };
        System.out.println(Arrays.toString(leftRightDifference(nums)));
    }
}
