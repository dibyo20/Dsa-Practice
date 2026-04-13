import java.util.*;

public class wallsAndGates {

    public static void findDist(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) { // Adding all gates (0) into queue
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                }
            }
        }

        int[][] dir = { // Directions: up, down, left, right
                { -1, 0 },
                { 1, 0 },
                { 0, -1 },
                { 0, 1 }
        };

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n
                        && rooms[nr][nc] == Integer.MAX_VALUE) { // No need to check for -1 as it will never be
                                                                 // Integer.MAX_VALUE

                    rooms[nr][nc] = rooms[r][c] + 1;
                    queue.offer(new int[] { nr, nc });
                }
            }
        }
    }

    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;

        int[][] grid = {
                { INF, -1, 0, INF },
                { INF, INF, INF, -1 },
                { INF, -1, INF, -1 },
                { 0, -1, INF, INF }
        };

        findDist(grid);

        for (int[] row : grid) {
            for (int val : row) {
                if (val == INF) { // This is just a check as in result we can have some rooms which are
                                  // unreachable from any gate, so they will remain INF.
                    System.out.print("INF ");
                } else {
                    System.out.print(val + " ");
                }
            }
            System.out.println();
        }
    }
}