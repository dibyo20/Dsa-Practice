public class countSubIslands {
    public static int count(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        int m = grid2.length;
        int n = grid2[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || grid2[i][j] == 0) {
            return true; // It is check that this cell is not part of the island in grid2, so it does not
                         // affect the sub-island condition. Hence, we return true.
        }

        grid2[i][j] = 0;

        boolean isSub = (grid1[i][j] == 1);

        boolean down = dfs(grid1, grid2, i + 1, j);
        boolean up = dfs(grid1, grid2, i - 1, j);
        boolean right = dfs(grid1, grid2, i, j + 1);
        boolean left = dfs(grid1, grid2, i, j - 1);

        return isSub && down && up && right && left;
    }

    public static void main(String[] args) {
        int [][] grid1 = {
                { 1, 1, 1, 0, 0 },
                { 0, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 1 },
                { 1, 1, 0, 1, 1 }
        };
        int [][] grid2 = {
                { 1, 1, 1, 0, 0 },
                { 0, 0, 1, 1, 0 },
                { 0, 1, 0, 0, 0 },
                { 1, 0, 1, 0, 1 },
                { 0, 1, 0, 1, 0 }
        };
        System.out.println(count(grid1, grid2));
    }
}
