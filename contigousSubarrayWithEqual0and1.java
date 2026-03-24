import java.util.HashMap;

public class contigousSubarrayWithEqual0and1 { // It is to find the maximum length of a contiguous subarray with equal
                                               // number of 0s and 1s. TC: O(n) SC: O(n)
    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum += -1;
            } else {
                sum += 1;
            }
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int nums[] = { 0, 1, 1, 1, 1, 1, 0, 0, 0 };
        System.out.println(findMaxLength(nums));
    }
}
