import java.util.*;

public class shortestPathInAGridWithObstaclesElimination {
    public static class State {
        int row;
        int col;
        int remainingK;
        int steps;

        State(int row, int col, int remainingK, int steps) {
            this.row = row;
            this.col = col;
            this.remainingK = remainingK;
            this.steps = steps;
        }
    }

    public static int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<State> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[m][n][k + 1];

        queue.offer(new State(0, 0, k, 0));
        visited[0][0][k] = true;
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.row == m - 1 && current.col == n - 1) {
                return current.steps;
            }

            for (int[] direction : directions) {
                int newRow = current.row + direction[0];
                int newCol = current.col + direction[1];

                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                    continue;
                }

                int newK = current.remainingK - grid[newRow][newCol];

                if (newK < 0 || visited[newRow][newCol][newK]) {
                    continue;
                }

                visited[newRow][newCol][newK] = true;
                queue.offer(new State(newRow, newCol, newK, current.steps + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 0 } };
        int k = 1;
        System.out.println(shortestPath(grid, k));
    }
}
