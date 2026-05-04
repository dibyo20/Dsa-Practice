public class longestSubarrayOfOneAfterDeletingOneElement {
    public static int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int maxlen = 0;
        int delCount = 0;

        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                delCount++;
            }

            while (delCount > 1) {
                if (nums[left] == 0) {
                    delCount--;
                }
                left++;
            }
            maxlen = Math.max(maxlen, right - left);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 1 };
        System.out.println(longestSubarray(nums));
    }
}
