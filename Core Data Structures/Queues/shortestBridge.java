import java.util.*;

public class shortestBridge {
    public static int shortestDist(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;

        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    found = true;
                    break;
                }
            }
        }

        int distance = 0;
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                        continue;
                    }

                    if (grid[nr][nc] == 1) {
                        return distance;
                    }

                    if (grid[nr][nc] == 0) {
                        grid[nr][nc] = 2;
                        queue.offer(new int[] { nr, nc });
                    }
                }
            }
            distance++;
        }
        return -1;
    }

    private static void dfs(int[][] grid, int r, int c, Queue<int[]> queue) {
        int n = grid.length;
        if (r < 0 || r >= n || c < 0 || c >= n || grid[r][c] != 1) {
            return;
        }

        grid[r][c] = 2;
        queue.offer(new int[] { r, c });
        dfs(grid, r + 1, c, queue);
        dfs(grid, r - 1, c, queue);
        dfs(grid, r, c + 1, queue);
        dfs(grid, r, c - 1, queue);
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 1 }, { 1, 0 } };
        System.out.println(shortestDist(grid));
    }
}
