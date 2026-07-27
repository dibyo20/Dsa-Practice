import java.util.Random;

public class randomPickIndex {
    public static class Solution {
        int[] nums;
        Random rand;

        public Solution(int[] nums) {
            this.nums = nums;
            rand = new Random();
        }

        public int pick(int target) {
            int count = 0;
            int ans = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    count++;

                    if (rand.nextInt(count) == 0) {
                        ans = i;
                    }
                }

            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 3, 3 };
        Solution solu = new Solution(nums);
        int ans = solu.pick(3);
        System.out.println(ans);
        ans = solu.pick(1);
        System.out.println(ans);
    }
}
