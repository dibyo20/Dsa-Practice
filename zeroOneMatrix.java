import java.util.*;

public class zeroOneMatrix {
    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) { // Pushing all 0s into queue, marking 1s as -1
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // Directions (up, down, left, right)

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1) {
                    mat[nr][nc] = mat[r][c] + 1;
                    queue.offer(new int[] { nr, nc });
                }
            }
        }
        return mat;
    }

    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 1, 1, 1 }
        };

        int[][] result = updateMatrix(mat);
        System.out.println("Output:");
        printMatrix(result);
    }
}
