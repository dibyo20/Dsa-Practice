import java.util.*;

public class numberOfDistinctIslands {
    public static int countDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Set<String> shapes = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<String> shape = new ArrayList<>();
                    dfs(grid, visited, i, j, i, j, shape);

                    shapes.add(String.join(",", shape));
                }
            }
        }

        return shapes.size();
    }

    private static void dfs(int[][] grid, boolean[][] visited,
            int row, int col,
            int baseRow, int baseCol,
            List<String> shape) {

        int m = grid.length;
        int n = grid[0].length;

        if (row < 0 || col < 0 || row >= m || col >= n ||
                visited[row][col] || grid[row][col] == 0) {
            return;
        }

        visited[row][col] = true;

        shape.add((row - baseRow) + ":" + (col - baseCol)); // Change the coordinates to relative coordinates i.e. change the base point to (0,0). This will help in comparing the shapes.

        dfs(grid, visited, row + 1, col, baseRow, baseCol, shape);
        dfs(grid, visited, row - 1, col, baseRow, baseCol, shape);
        dfs(grid, visited, row, col + 1, baseRow, baseCol, shape);
        dfs(grid, visited, row, col - 1, baseRow, baseCol, shape);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}
        };
        System.out.println(countDistinctIslands(grid)); 
    }
}
