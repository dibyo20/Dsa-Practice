import java.util.*;

public class pathWithMinimumEffort {
    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        dist[0][0] = 0;
        pq.offer(new int[] { 0, 0, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int row = curr[0];
            int col = curr[1];
            int effort = curr[2];

            if (effort > dist[row][col]) {
                continue;
            }

            if (row == n - 1 && col == m - 1) {
                return effort;
            }

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int edgeWeight = Math.abs(heights[row][col] - heights[nr][nc]);
                    int newEffort = Math.max(effort, edgeWeight);
                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.offer(new int[] { nr, nc, newEffort });
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] heights = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
        System.out.println(minimumEffortPath(heights));
    }
}
