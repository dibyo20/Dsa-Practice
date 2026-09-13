public class minimumNumberOfKConsecutiveBitFlips {
    public static int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        boolean[] isFlipped = new boolean[n];
        int flipCount = 0;

        for (int i = 0; i < n; i++) {
            if (i >= k && isFlipped[i - k]) {
                flipCount--;
            }

            int current = nums[i] ^ (flipCount % 2);
            if (current == 0) {
                if (i + k > n) {
                    return -1;
                }
                isFlipped[i] = true;
                flipCount++;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 0, 1, 0, 1, 1, 0 };
        int k = 3;
        System.out.println(minKBitFlips(nums, k));
    }
}
