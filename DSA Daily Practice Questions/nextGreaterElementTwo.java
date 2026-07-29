import java.util.*;

public class nextGreaterElementTwo {
    public static int[] nextGreater(int[] nums) {
        int n = nums.length;
        Deque<Integer> s = new ArrayDeque<>();
        int[] ans = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {
            int curr = nums[i % n];
            while (!s.isEmpty() && s.peek() <= curr) {
                s.pop();
            }

            if (i < n) {
                if (s.isEmpty()) {
                    ans[i] = -1;
                } else {
                    ans[i] = s.peek();
                }
            }
            s.push(curr);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 3 };
        System.out.println(Arrays.toString(nextGreater(nums)));
    }
}
