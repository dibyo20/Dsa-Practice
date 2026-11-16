import java.util.*;

public class nearestExitFromEntranceInMaze {
    public static int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { entrance[0], entrance[1] });
        maze[entrance[0]][entrance[1]] = '+';
        int steps = 0;
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];

                if ((x == 0 || x == m - 1 || y == 0 || y == n - 1) && (x != entrance[0] || y != entrance[1])) {
                    return steps;
                }

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] == '.') {
                        q.offer(new int[] { newX, newY });
                        maze[newX][newY] = '+';
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        char[][] maze = { { '+', '+', '.', '+' }, { '.', '.', '.', '+' }, { '+', '+', '+', '.' } };
        int[] entrance = { 1, 2 };
        System.out.println(nearestExit(maze, entrance));
    }
}
