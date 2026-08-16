public class maximumAlternatingSubsequenceSum {
    public static long maxAlternatingSum(int[] nums) {
        long even = 0;
        long odd = 0;
        for (int num : nums) {
            long newOdd = Math.max(odd, even + num);
            long newEven = Math.max(even, odd - num);

            odd = newOdd;
            even = newEven;
        }
        return odd;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 2, 5, 3 };
        System.out.println(maxAlternatingSum(nums));
    }
}
