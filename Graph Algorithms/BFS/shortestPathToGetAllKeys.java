import java.util.*;;

public class shortestPathToGetAllKeys {
    public static int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int startRow = 0;
        int startCol = 0;
        int k = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);

                if (ch == '@') {
                    startRow = i;
                    startCol = j;
                }

                if (ch >= 'a' && ch <= 'f') {
                    k++;
                }
            }
        }

        int target = (1 << k) - 1;
        boolean[][][] visited = new boolean[m][n][1 << k];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { startRow, startCol, 0, 0 });
        visited[startRow][startCol][0] = true;

        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            int mask = curr[2];
            int steps = curr[3];

            if (mask == target) {
                return steps;
            }

            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                char currChar = grid[nr].charAt(nc);

                if (currChar == '#') {
                    continue;
                }

                int newMask = mask;

                if (currChar >= 'a' && currChar <= 'f') {
                    newMask |= (1 << (currChar - 'a'));
                }

                if (currChar >= 'A' && currChar <= 'F' && ((mask & (1 << (currChar - 'A'))) == 0)) {
                    continue;
                }

                if (visited[nr][nc][newMask]) {
                    continue;
                }

                visited[nr][nc][newMask] = true;
                q.add(new int[] { nr, nc, newMask, steps + 1 });
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] grid = { "@.a..", "###.#", "b.A.B" };
        System.out.println(shortestPathAllKeys(grid));
    }
}
