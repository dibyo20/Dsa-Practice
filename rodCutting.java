public class rodCutting {
    public static int rodcut(int rodLens, int[] len, int[] price) { // TC: O(n*w), SC: O(n*w)
        int n = price.length;
        int dp[][] = new int[price.length + 1][rodLens + 1];
        for (int i = 0; i <= price.length; i++) {
            dp[i][0] = 0; // len is 0, max value is 0
        }
        for (int j = 0; j <= rodLens; j++) {
            dp[0][j] = 0; // no rodlen, max value is 0
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < rodLens + 1; j++) {
                if (len[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - len[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        print(dp);
        return dp[n][rodLens]; // The maximum value for price with len n
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
        int[] len = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int rodLen = 8;
        System.out.println("Maximum Price = " + rodcut(rodLen, len, price));
    }
}
