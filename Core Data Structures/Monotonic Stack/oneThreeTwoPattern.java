import java.util.*;

public class oneThreeTwoPattern {
    public static boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int second = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < second) {
                return true;
            }

            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                second = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 2 };
        System.out.println(find132pattern(nums));
    }
}
