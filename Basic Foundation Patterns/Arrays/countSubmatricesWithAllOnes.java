public class countSubmatricesWithAllOnes {
    public static int countSubmatricesWithOnes(int[][] matrix) {
        int[] heights = new int[matrix[0].length];
        int ans = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            for (int j = 0; j < matrix[0].length; j++) {
                int minHeight = Integer.MAX_VALUE;
                for (int k = j; k >= 0; k--) {
                    minHeight = Math.min(minHeight, heights[k]);
                    ans += minHeight;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 0, 1 },
                { 1, 1, 0 },
                { 1, 1, 0 }
        };
        System.out.println(countSubmatricesWithOnes(matrix));
    }
}
