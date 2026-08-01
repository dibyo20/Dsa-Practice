public class gridGame {
    public static long gridgame(int[][] grid) {
        int n = grid[0].length;

        long topSum = 0;
        for (int num : grid[0]) {
            topSum += num;
        }

        long bottomSum = 0;
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            topSum -= grid[0][i];

            long secondRobot = Math.max(topSum, bottomSum);

            ans = Math.min(ans, secondRobot);

            bottomSum += grid[1][i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = { { 2, 5, 4 }, { 1, 5, 1 } };
        System.out.println(gridgame(grid));
    }
}
