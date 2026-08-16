public class maximumSumOfTwoNonOverlappingSubarrays {
    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int ans1 = solve(prefix, firstLen, secondLen);
        int ans2 = solve(prefix, secondLen, firstLen);
        return Math.max(ans1, ans2);
    }

    private static int solve(int[] prefix, int leftLen, int rightLen) {
        int maxLeft = 0;
        int ans = 0;

        for (int i = leftLen + rightLen; i <= prefix.length - 1; i++) {
            int leftSum = prefix[i - rightLen] - prefix[i - rightLen - leftLen];
            maxLeft = Math.max(maxLeft, leftSum);

            int rightSum = prefix[i] - prefix[i - rightLen];
            ans = Math.max(ans, maxLeft + rightSum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 8, 1, 3, 2, 1, 8, 9, 0 };
        int firstLen = 3;
        int secondLen = 2;
        System.out.println(maxSumTwoNoOverlap(nums, firstLen, secondLen));
    }
}
