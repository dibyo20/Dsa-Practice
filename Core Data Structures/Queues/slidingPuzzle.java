import java.util.*;

public class slidingPuzzle {
    public static int solvePuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        String target = "123450";
        if (start.equals(target))
            return 0;

        int[][] neighbours = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(target))
                    return moves;
                int zeroIndex = curr.indexOf('0');
                for (int nextIndex : neighbours[zeroIndex]) {
                    char[] chars = curr.toCharArray();
                    chars[zeroIndex] = chars[nextIndex];
                    chars[nextIndex] = '0';
                    String next = new String(chars);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] board = { { 1, 2, 3 }, { 5, 4, 0 } };
        System.out.println(solvePuzzle(board));
    }
}
