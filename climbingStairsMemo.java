import java.util.*;

public class climbingStairsMemo {  // TC: O(n), SC: O(n)
    public static int climbStairs(int n, int[] ways) { // TC: O(n), SC: O(n)
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (ways[n] != -1) {
            return ways[n];
        }
        ways[n] = climbStairs(n - 1, ways) + climbStairs(n - 2, ways);
        return ways[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int ways[] = new int[n + 1];
        Arrays.fill(ways, -1);
        System.out.println("Number of ways to climb " + n + " stairs: " + climbStairs(n, ways));
    }
}
