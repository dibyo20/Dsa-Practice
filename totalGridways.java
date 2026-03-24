public class totalGridways {
    public static int gridWays(int i, int j, int n, int m){   // TC O(2^(n+m)), SC O(n+m)
        if (i == n - 1 && j == m - 1) {
            return 1;   // Reached the destination
        }else if (i == n || j == m) {
            return 0;   // Out of bounds
        }

        int w1 = gridWays(i + 1, j, n, m);  // Move down
        int w2 = gridWays(i, j + 1, n, m);  // Move right
        return w1 + w2;   // Total ways 
    }

    public static void main(String[] args) {
        int n = 10;  // rows
        int m = 10;  // columns
        int totalWays = gridWays(0, 0, n, m);
        System.out.println("Total ways to reach the destination: " + totalWays);
    }
}

// Note: To solve the problem more efficiently, we can use permutation and combination concept or dynamic programming approach to reduce the time complexity to O(n*m) with SC O(n*m) or O(m)
// So to do by permutation and combination, we need to take (n-1) down moves and (m-1) right moves, total moves will be (n-1)+(m-1) = n+m-2
// and we need to choose (n-1) moves from these total moves or (m-1) moves from these total moves. So the formula will be = (n+m-2)! / ( (n-1)! * (m-1)! ).

// Similarly, we can use dynamic programming to store the intermediate results in a 2D array to avoid recalculating the same subproblems.
