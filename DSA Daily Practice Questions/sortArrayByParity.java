public class sortArrayByParity {
    public static int[] sortByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }
            while (left < right && nums[right] % 2 != 0) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 4 };
        int[] ans = sortByParity(nums);
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }
}
