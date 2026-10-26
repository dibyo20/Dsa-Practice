import java.util.*;

public class nQueens {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char board[][] = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        nqueens(board, 0, ans);
        return ans;
    }

    public static void nqueens(char board[][], int row, List<List<String>> ans) {
        if (row == board.length) {
            List<String> solu = new ArrayList<>();

            for (int i = 0; i < board.length; i++) {
                solu.add(new String(board[i]));
            }
            ans.add(solu);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                nqueens(board, row + 1, ans);
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
        System.out.println(solveNQueens(4));
    }
}
