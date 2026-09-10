import java.util.Stack;

public class sumOfSubarrayRanges {
    public static long subArrayRanges(int[] nums) {
        int n = nums.length;
        long minSum = 0, maxSum = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            long leftChoices = i - left[i];
            long rightChoices = right[i] - i;
            minSum += (long) nums[i] * leftChoices * rightChoices;
        }

        stack.clear();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            long leftChoices = i - left[i];
            long rightChoices = right[i] - i;
            maxSum += (long) nums[i] * leftChoices * rightChoices;
        }
        return maxSum - minSum;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(subArrayRanges(nums));
    }
}
