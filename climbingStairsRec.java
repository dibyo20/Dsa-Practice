public class climbingStairsRec {
    public static int climbStairs(int n) { // TC: O(2^n), SC: O(n)
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Number of ways to climb " + n + " stairs: " + climbStairs(n));
    }
}
