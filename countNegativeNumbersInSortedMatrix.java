public class countNegativeNumbersInSortedMatrix {
    public static int countNegatives(int[][] grid) {
        int count = 0;

        for (int row[] : grid) {
            int left = 0;
            int right = row.length - 1;
            int firstNegIndex = row.length;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (row[mid] < 0) {
                    firstNegIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            count += (row.length - firstNegIndex);
        }
        return count;
    }

    public static int countNegativesOpt(int[][] grid) {
        int row = 0;
        int col = grid[0].length - 1;
        int count = 0;

        while (row < grid.length && col >= 0) {
            if (grid[row][col] < 0) {
                count += (grid.length - row);
                col--;
            } else {
                row++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int grid[][] = { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };
        System.out.println(countNegatives(grid));
        System.out.println(countNegativesOpt(grid));
    }
}
