public class islandPerimeter {
    public static int perimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int perimeter = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0)
                        perimeter++;
                    if (i == m - 1 || grid[i + 1][j] == 0)
                        perimeter++;
                    if (j == 0 || grid[i][j - 1] == 0)
                        perimeter++;
                    if (j == n - 1 || grid[i][j + 1] == 0)
                        perimeter++;
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        System.out.println(perimeter(grid));
    }
}
