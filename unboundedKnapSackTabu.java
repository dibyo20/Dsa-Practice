public class unboundedKnapSackTabu {
    public static int unboundedknapSack(int w, int[] wt, int[] vals) { // TC: O(n*w), SC: O(n*w)
        int n = vals.length;
        int dp[][] = new int[vals.length + 1][w + 1];
        for (int i = 0; i <= vals.length; i++) {
            dp[i][0] = 0; // weight is 0, max value is 0
        }
        for (int j = 0; j <= w; j++) {
            dp[0][j] = 0; // no items, max value is 0
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(vals[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        print(dp);
        return dp[n][w]; // The maximum value for the knapsack with weight w
    }

    public static void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] wt = { 2, 5, 1, 3, 4 };
        int[] vals = { 15, 14, 10, 45, 30 };
        int w = 7;
        System.out.println("Maximum value in Knapsack = " + unboundedknapSack(w, wt, vals));
    }
}
