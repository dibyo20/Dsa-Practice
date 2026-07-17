import java.util.*;

public class maximumGap {
    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max)
            return 0;

        int bucketSize = Math.max(1,
                (int) Math.ceil((double) (max - min) / (n - 1)));

        int bucketCount = (max - min) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        boolean[] used = new boolean[bucketCount];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        for (int num : nums) {
            int index = (num - min) / bucketSize;
            bucketMin[index] = Math.min(bucketMin[index], num);
            bucketMax[index] = Math.max(bucketMax[index], num);

            used[index] = true;
        }

        int ans = 0;
        int prevMax = min;

        for (int i = 0; i < bucketCount; i++) {
            if (!used[i])
                continue;

            ans = Math.max(ans, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }
        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 3, 6, 9, 1 };
        System.err.println(maxGap(nums));
    }
}
