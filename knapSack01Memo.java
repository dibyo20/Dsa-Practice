public class knapSack01Memo {
    public static int knapSack(int w, int[] wt, int[] vals, int n, int[][] dp) { // TC: O(n*w), SC: O(n*w)
        if (w == 0 || n == 0) {
            return 0;
        }

        if(dp[n][w] != -1) {
            return dp[n][w]; // Returning the cached result
        }

        if (wt[n - 1] <= w) {
            int ans1 = vals[n - 1] + knapSack(w - wt[n - 1], wt, vals, n - 1, dp); // including the item
            int ans2 = knapSack(w, wt, vals, n - 1, dp); // excluding the item
            dp[n][w] = Math.max(ans1, ans2);
            return dp[n][w]; // Storing the result in the memoization table
        } else {
            dp[n][w] = knapSack(w, wt, vals, n - 1, dp); // excluding the item
            return dp[n][w]; 
        }
    }

    public static void main(String[] args) {
        int[] wt = { 2, 5, 1, 3, 4 };
        int[] vals = { 15, 14, 10, 45, 30 };
        int w = 7;
        int dp [][] = new int[vals.length + 1][w + 1];
        for (int i = 0; i <= vals.length; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = -1; // Initializing the memoization table
            }
        }
        System.out.println("Maximum value in Knapsack = " + knapSack(w, wt, vals, vals.length, dp));
    }
}
