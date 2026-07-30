import java.util.*;

public class maximumWidthRamp {
    public static int maxWidthRamp(int[] nums) {
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

    public static void main(String[] args) {
        int[] nums = { 6, 0, 8, 2, 1, 5 };
        System.out.println(maxWidthRamp(nums));
    }
}
