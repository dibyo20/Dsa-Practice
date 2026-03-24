public class fibonacciMemoTabu {
    public static int memorizedFibonacci(int n, int[] memo) {  // TC: O(n), SC: O(n)
        if (n <= 1) {
            return n;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = memorizedFibonacci(n - 1, memo) + memorizedFibonacci(n - 2, memo);
        return memo[n];
    }

    public static int tabulationFibonacci(int n) {  // TC: O(n), SC: O(n) 
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 10; 
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1; // Initialize memoization array
        }
        System.out.println("Fibonacci using Memoization for " + n + ": " + memorizedFibonacci(n, memo));
        System.out.println("Fibonacci using Tabulation for " + n + ": " + tabulationFibonacci(n));
    }
}
