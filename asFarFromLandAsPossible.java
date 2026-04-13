import java.util.LinkedList;
import java.util.Queue;

public class asFarFromLandAsPossible {
    public static int maxDist(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int maxDist = 0;

        boolean hasLand = false;
        boolean hasWater = false;

        for (int i = 0; i < m; i++) { // Pushing all 1s into queue, marking 1s as -1
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    hasLand = true;
                    queue.offer(new int[] { i, j });
                } else {
                    hasWater = true;
                    grid[i][j] = -1;
                }
            }
        }

        if (!hasLand || !hasWater) {
            return -1;
        }

        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // Directions (up, down, left, right)

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == -1) {
                    grid[nr][nc] = grid[r][c] + 1;
                    queue.offer(new int[] { nr, nc });
                    maxDist = Math.max(maxDist, grid[nr][nc]);
                }
            }
        }
        return maxDist-1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 0, 1 },
                { 0, 0, 0 },
                { 1, 0, 1 }
        };
        System.out.println(maxDist(grid));
    }
}
