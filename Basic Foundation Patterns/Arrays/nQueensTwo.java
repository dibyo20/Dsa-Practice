import java.util.*;

public class nQueensTwo {
    public static int count = 0;

    public static int totalNQueens(int n) {
        count = 0;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        nqueens(board, 0);
        return count;
    }

    public static void nqueens(char board[][], int row) {
        if (row == board.length) {
            count++;
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                nqueens(board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    public static Boolean isSafe(char board[][], int row, int col) {
        // check up column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check left up diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check right up diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
}
