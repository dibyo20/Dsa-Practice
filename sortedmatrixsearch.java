public class sortedmatrixsearch {

    public static boolean stairCaseSearch(int matrix[][], int target) {
        int rows = 0;
        int cols = matrix[0].length-1;

        while(rows<matrix.length && cols >= 0) {     // TIME COMPLEXITY: O(n + m) where n is the number of rows and m is the number of columns
            if(matrix[rows][cols] == target) {
                System.out.println("Element found at: " + rows + ", " + cols);
                return true; // Element found
            } else if(matrix[rows][cols] > target) {
                cols--; // Move left
            } else {
                rows++; // Move down
            }
        }
        return false; // Element not found
    }

    public static void main(String[] args) {
        int matrix[][] = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 }
        };
        int target = 29
        ;
        System.out.println("Element found: " + stairCaseSearch(matrix, target));
    }
}
