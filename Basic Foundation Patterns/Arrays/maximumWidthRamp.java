import java.util.*;

public class maximumWidthRamp {
    public static int maxWidthRampMethodOne(int[] nums) {
        int n = nums.length;
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> Integer.compare(nums[a], nums[b]));

        int maxWidth = 0;
        int minIndex = n;

        for (int i : indices) {
            maxWidth = Math.max(maxWidth, i - minIndex);
            minIndex = Math.min(minIndex, i);
        }

        return maxWidth;
    }

    public static int maxWidthRampMethodTwo(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;

        // Building decreasing stack
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }

        // Traversing from right
        for (int j = nums.length - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                ans = Math.max(ans, j - stack.pop());
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 6, 0, 8, 2, 1, 5 };
        System.out.println(maxWidthRampMethodOne(nums));
        System.out.println(maxWidthRampMethodTwo(nums));
    }
}
