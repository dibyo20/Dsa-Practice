import java.util.*;

public class pacificAtlanticWaterFlow {
    static int m, n;
    static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) { // left edge
            dfs(i, 0, pacific, heights);
        }

        for (int j = 0; j < n; j++) { // top edge
            dfs(0, j, pacific, heights);
        }

        for (int i = 0; i < m; i++) { // right edge
            dfs(i, n - 1, atlantic, heights);
        }

        for (int j = 0; j < n; j++) { // bottom edge
            dfs(m - 1, j, atlantic, heights);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private static void dfs(int r, int c, boolean[][] visited, int[][] heights) {
        visited[r][c] = true;

        for (int[] dirs : directions) {
            int nr = r + dirs[0];
            int nc = c + dirs[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, visited, heights); // only move to higher or equal cells
            }
        }
    }

    public static void main(String[] args) {
        int heights[][] = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };
        System.out.println(pacificAtlantic(heights));
    }
}
