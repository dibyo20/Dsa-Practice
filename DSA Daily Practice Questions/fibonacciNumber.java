import java.util.Arrays;

public class fibonacciNumber {
    public static int[] dp;

    public static int fib(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n);
    }

    public static int solve(int n) {
        if (n <= 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = solve(n - 1) + solve(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
    }
}
