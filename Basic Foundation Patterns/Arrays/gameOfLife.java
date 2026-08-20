public class gameOfLife {
    public static void Life(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] dir = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCount = 0;

                for (int[] d : dir) {
                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                        if (board[ni][nj] == 1 || board[ni][nj] == 2) {
                            liveCount++;
                        }
                    }
                }

                if (board[i][j] == 1) {
                    if (liveCount < 2 || liveCount > 3) {
                        board[i][j] = 2;
                    }
                } else if (board[i][j] == 0) {
                    if (liveCount == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        Life(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
