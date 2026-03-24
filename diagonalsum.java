public class diagonalsum {

    public static int diagonalSum(int matrix[][]) {
        int sum = 0;
        int n = matrix.length;

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (i == j) {
        //             sum += matrix[i][j];
        //         } else if (i + j == n - 1) {
        //             sum += matrix[i][j];
        //         }
        //     }
        // }

        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];     // Primary diagonal
            if(i != n - 1 - i)     // Avoid double counting the center element in odd-sized matrices
              sum += matrix[i][n - 1 - i];     // Secondary diagonal
        }

        return sum;
    }

    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println("Diagonal Sum: " + diagonalSum(matrix));
    }
}
