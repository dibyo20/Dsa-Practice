public class pathWithMaximumGold {
    public static int getMaximumGold(int[][] grid) {
        int maxGold = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }

        return maxGold;
    }

    private static int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        int gold = grid[i][j];

        grid[i][j] = 0;

        int up = dfs(grid, i - 1, j);
        int down = dfs(grid, i + 1, j);
        int left = dfs(grid, i, j - 1);
        int right = dfs(grid, i, j + 1);

        grid[i][j] = gold; // While backtracking, we restore the value of the cell to its original value.

        return gold + Math.max(Math.max(up, down), Math.max(left, right));
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 0, 6, 0 },
                { 5, 8, 7 },
                { 0, 9, 0 }
        };
        System.out.println(getMaximumGold(grid));
    }
}
