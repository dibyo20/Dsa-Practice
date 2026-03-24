import java.util.Arrays;

public class findKthSmallestPairDistance {
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (countPairs(nums, mid, k)) {
                high = mid - 1; // mid is valid → try smaller distance
            } else {
                low = mid + 1; // not enough pairs → need bigger distance
            }
        }
        return low;
    }

    private static boolean countPairs(int[] nums, int dist, int k) {
        int left = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            while ((nums[right] - nums[left]) > dist) {
                left++;
            }
            count += (right - left);
        }
        return count >= k;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, 1 };
        int k = 1;
        System.out.println(smallestDistancePair(nums, k));
    }
}
