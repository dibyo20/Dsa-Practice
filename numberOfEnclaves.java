public class numberOfEnclaves {
    public static int countEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) { // Traverse the first and last column of each row and perform DFS to mark all
                                      // connected land cells as visited (0).
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);

        }

        for (int j = 0; j < n; j++) { // Traverse the first and last row of each column and perform DFS to mark all
                                      // connected land cells as visited (0).
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        int grid[][] = {
                { 0, 0, 0, 0 },
                { 1, 0, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 }
        };
        System.out.println(countEnclaves(grid));
    }
}
