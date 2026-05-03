import java.util.*;

public class minimumDifferenceBetweenHighestAndLowestOfKScores {
    public static int minDiff(int nums[], int k) {
        if (k == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = k - 1;
        int min = Integer.MAX_VALUE;

        while (right < nums.length) {
            int diff = nums[right] - nums[left];
            min = Math.min(min, diff);
            left++;
            right++;
        }
        return min;
    }
    
    public static void main(String[] args) {
        int nums[] = { 9, 4, 1, 7 };
        int k = 2;
        System.out.println(minDiff(nums, k));
    }
}