import java.util.HashMap;

public class equalRowAndColumnPairs {
    public static int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]).append(",");
            }
            String row = sb.toString();
            map.put(row, map.getOrDefault(row, 0) + 1);
        }

        int count = 0;
        for (int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(grid[i][j]).append(",");
            }
            String col = sb.toString();
            count += map.getOrDefault(col, 0);
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = { { 3, 2, 1 }, { 1, 7, 6 }, { 2, 7, 7 } };
        System.out.println(equalPairs(grid));
    }
}
