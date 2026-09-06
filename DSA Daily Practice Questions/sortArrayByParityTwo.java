public class sortArrayByParityTwo {
    public static int[] sortByParityTwo(int[] nums) {
        int even = 0;
        int odd = 1;
        while (even < nums.length && odd < nums.length) {
            while (even < nums.length && nums[even] % 2 == 0) {
                even += 2;
            }
            while (odd < nums.length && nums[odd] % 2 == 1) {
                odd += 2;
            }
            if (even < nums.length && odd < nums.length) {
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 2, 5, 7 };
        int[] ans = sortByParityTwo(nums);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
