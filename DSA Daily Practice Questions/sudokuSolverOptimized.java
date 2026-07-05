public class sudokuSolverOptimized {
    static boolean[][] rows = new boolean[9][10];
    static boolean[][] cols = new boolean[9][10];
    static boolean[][] boxes = new boolean[9][10];

    public static void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0';
                    int box = (i / 3) * 3 + j / 3;
                    rows[i][digit] = true;
                    cols[j][digit] = true;
                    boxes[box][digit] = true;
                }
            }
        }
        solve(board, 0, 0);
    }

    public static boolean solve(char[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }

        int nextRow = row;
        int nextCol = col + 1;
        if (col == 8) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (board[row][col] != '.') {
            return solve(board, nextRow, nextCol);
        }

        int box = (row / 3) * 3 + (col / 3);
        for (int digit = 1; digit <= 9; digit++) {
            if (rows[row][digit] || cols[col][digit] || boxes[box][digit]) {
                continue;
            }

            board[row][col] = (char) (digit + '0');

            rows[row][digit] = true;
            cols[col][digit] = true;
            boxes[box][digit] = true;

            if (solve(board, nextRow, nextCol)) {
                return true;
            }

            board[row][col] = '.';
            rows[row][digit] = false;
            cols[col][digit] = false;
            boxes[box][digit] = false;
        }
        return false;
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char board[][] = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        solveSudoku(board);
        printBoard(board);
    }
}
