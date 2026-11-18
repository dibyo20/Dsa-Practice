public class minimumOperationsToMakeBinaryArrayElementsEqualToOneOne {
    public static int minOperations(int[] nums) {
        int steps = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (i + 2 >= nums.length) {
                    return -1;
                }
                steps++;
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 1, 0, 0 };
        System.out.println(minOperations(nums));
    }
}
