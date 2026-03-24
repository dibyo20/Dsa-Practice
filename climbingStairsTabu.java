import java.util.Arrays;

public class climbingStairsTabu {  // TC: O(n), SC: O(n)
    public static int climbStairs(int n, int[] ways) {
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
        int n = 5;
        int ways[] = new int[n + 1];
        Arrays.fill(ways, -1);
        System.out.println("Number of ways to climb " + n + " stairs: " + climbStairs(n, ways));
    }
}
