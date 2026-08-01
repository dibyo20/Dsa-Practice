import java.util.HashMap;

public class numberOfSubmatricesThatSumToTarget {
    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;
        for (int top = 0; top < rows; top++) {
            int colSum[] = new int[cols];
            for (int bottom = top; bottom < rows; bottom++) {
                for (int col = 0; col < cols; col++) {
                    colSum[col] += matrix[bottom][col];
                }
                count += subarraySum(colSum, target);
            }
        }
        return count;
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefix = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            if (map.containsKey(prefix - k)) {
                count += map.get(prefix - k);
            }
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 0, 2, -1 }, { -2, -1, 5 }, { 0, 1, 2 } };
        int target = 0;
        System.out.println(numSubmatrixSumTarget(matrix, target));
    }
}
