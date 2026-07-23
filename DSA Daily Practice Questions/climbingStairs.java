public class climbingStairs {
    public static int climbStairs(int n) {
        if (n == 0 || n == 1)
            return 1;

        if (n == 0)
            return 0;

        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println("Number of ways to climb " + n + " stairs: " + climbStairs(n));
    }
}
