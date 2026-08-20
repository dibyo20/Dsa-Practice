public class minimumPathSum {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        return minPath(grid, 0, 0, memo);
    }

    private static int minPath(int[][] grid, int r, int c, int[][] memo) {
        if (r == grid.length - 1 && c == grid[0].length - 1) {
            return grid[r][c];
        }

        if (r >= grid.length || c >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (memo[r][c] != 0) {
            return memo[r][c];
        }

        int down = minPath(grid, r + 1, c, memo);
        int right = minPath(grid, r, c + 1, memo);

        memo[r][c] = Math.min(down, right) + grid[r][c];
        return memo[r][c];
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 3, 1 },
                { 1, 5, 1 },
                { 4, 2, 1 }
        };
        System.out.println(minPathSum(grid));
    }
}
