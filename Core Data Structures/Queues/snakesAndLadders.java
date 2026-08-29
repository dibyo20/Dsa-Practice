import java.util.*;

public class snakesAndLadders {
    public static int countMoves(int[][] board) {
        int n = board.length;
        int target = n * n;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[target + 1];
        q.add(1);
        visited[1] = true;
        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int curr = q.poll();
                if (curr == target)
                    return moves;

                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next > target)
                        continue;

                    int rowFromBottom = (next - 1) / n;
                    int row = n - 1 - rowFromBottom;
                    int col = (next - 1) % n;

                    if (rowFromBottom % 2 == 1)
                        col = n - 1 - col;

                    if (board[row][col] != -1)
                        next = board[row][col];

                    if (next == target)
                        return moves + 1;

                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] board = {
                { -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, 35, -1, -1, 13, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, 15, -1, -1, -1, -1 }
        };
        System.out.println(countMoves(board));
    }
}
