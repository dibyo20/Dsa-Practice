public class detectCyclesIn2DGrid {
    public static int m, n;
    public static boolean[][] visited;

    public static boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, i, j, -1, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] grid, int row, int col, int parentRow, int parentCol) {
        visited[row][col] = true;
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int[] dir : directions) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (nr < 0 || nc < 0 || nr >= m || nc >= n) {
                continue;
            }

            if (grid[nr][nc] != grid[row][col]) {
                continue;
            }

            if (nr == parentRow && nc == parentCol) {
                continue;
            }

            if (visited[nr][nc]) {
                return true;
            }

            if (dfs(grid, nr, nc, row, col)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'a', 'a', 'a', 'a'},
            {'a', 'b', 'b', 'a'},
            {'a', 'b', 'b', 'a'},
            {'a', 'a', 'a', 'a'}
        };

        System.out.println(containsCycle(grid));
    }
}
