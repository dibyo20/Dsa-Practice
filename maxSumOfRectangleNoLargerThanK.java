import java.util.TreeSet;

public class maxSumOfRectangleNoLargerThanK {
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;
        for (int left = 0; left < cols; left++) {
            int[] rowSum = new int[rows];
            for (int right = left; right < cols; right++) {
                for (int r = 0; r < rows; r++) {
                    rowSum[r] += matrix[r][right];
                }
                maxSum = Math.max(maxSum, maxSubArrayNoMoreThanK(rowSum, k));
            }
        }
        return maxSum;
    }

    private static int maxSubArrayNoMoreThanK(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int prefix = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            prefix += num;
            Integer target = set.ceiling(prefix - k);
            if (target != null) {
                maxSum = Math.max(maxSum, prefix - target);
            }
            set.add(prefix);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 0, 1},
            {0, -2, 3}
        };
        int k = 2;
        System.out.println(maxSumSubmatrix(matrix, k));
    }
}
