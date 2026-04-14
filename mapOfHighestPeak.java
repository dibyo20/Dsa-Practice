import java.util.*;

public class mapOfHighestPeak {
    public static int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        int[][] height = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    queue.offer(new int[] { i, j });
                } else {
                    height[i][j] = -1;
                }
            }
        }
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n && height[nr][nc] == -1) {
                    height[nr][nc] = height[r][c] + 1;
                    queue.offer(new int[] { nr, nc });
                }
            }
        }
        return height;
    }

    public static void main(String[] args) {
        int[][] isWater = {
                { 0, 1 },
                { 0, 0 }
        };
        int[][] result = highestPeak(isWater);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
