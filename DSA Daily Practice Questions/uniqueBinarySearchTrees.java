public class uniqueBinarySearchTrees {
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if (n >= 1) {
            dp[1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static int numTreesRecursion(int n) {
        int[] dp = new int[n + 1];
        return numTreesRecursionHelper(n, dp);
    }

    public static int numTreesRecursionHelper(int n, int[] dp) {
        if (n == 0 || n == 1)
            return 1;

        if (dp[n] != 0)
            return dp[n];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += numTreesRecursionHelper(i, dp) * numTreesRecursionHelper(n - i - 1, dp);
        }

        dp[n] = ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
        System.out.println(numTreesRecursion(3));
    }
}
