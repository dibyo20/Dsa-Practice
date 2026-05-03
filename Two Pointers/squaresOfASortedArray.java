import java.util.*;

public class squaresOfASortedArray {
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        int left = 0, right = n - 1, index = n - 1;

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[index] = nums[left] * nums[left];
                left++;
            } else {
                result[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = { -4, -1, 0, 3, 10 };
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
}
