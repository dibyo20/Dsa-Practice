import java.util.*;

public class longestIncreasingPathInAMatrix {
    public static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        int maxLength = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLength = Math.max(maxLength, dfs(matrix, i, j, dp));
            }
        }

        return maxLength;
    }

    public static int dfs(int[][] matrix, int row, int col, int[][] dp) {
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int pathLength = 1;

        int[] dr = { 0, 0, -1, 1 };
        int[] dc = { -1, 1, 0, 0 };

        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix[0].length
                    && matrix[nr][nc] > matrix[row][col]) {
                pathLength = Math.max(pathLength, 1 + dfs(matrix, nr, nc, dp));
            }
        }

        dp[row][col] = pathLength;
        return pathLength;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
        System.out.println(longestIncreasingPath(matrix));
    }
}
