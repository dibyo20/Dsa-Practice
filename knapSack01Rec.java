public class knapSack01Rec {
    public static int knapSack(int w, int[] wt, int[] vals, int n) {
        if (w == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] <= w) {
            int ans1 = vals[n - 1] + knapSack(w - wt[n - 1], wt, vals, n - 1); // include the item
            int ans2 = knapSack(w, wt, vals, n - 1); // exclude the item
            return Math.max(ans1, ans2);
        } else {
            return knapSack(w, wt, vals, n - 1); // exclude the item
        }
    }

    public static void main(String[] args) {
        int[] wt = { 2, 5, 1, 3, 4 };
        int[] vals = { 15, 14, 10, 45, 30 };
        int w = 7;
        System.out.println("Maximum value in Knapsack = " + knapSack(w, wt, vals, vals.length));
    }
}
