import java.util.*;

public class shortestPathInBinaryMatrix {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        int[][] dirs = {  // These are the 8 possible directions.
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0, 1 });

        grid[0][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            if (r == n - 1 && c == n - 1) {
                return dist;
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) { // If the cell is not visited yet and is not a wall(i.e '0') then we can visit it.
                    q.offer(new int[] { nr, nc, dist + 1 });
                    grid[nr][nc] = 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int grid[][] = {
                { 0, 0, 0 },
                { 1, 1, 0 },
                { 1, 1, 0 }
        };
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
