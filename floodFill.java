public class floodFill {
    public static int[][] fill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        if (originalColor == color)
            return image;

        dfs(image, sr, sc, originalColor, color);
        return image;
    }

    private static void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != originalColor) // To check if the pixel is out of bounds or if it is not the original color.
            return;

        image[r][c] = newColor;
        dfs(image, r - 1, c, originalColor, newColor); // up
        dfs(image, r + 1, c, originalColor, newColor); // down
        dfs(image, r, c - 1, originalColor, newColor); // left
        dfs(image, r, c + 1, originalColor, newColor); // right
    }

    public static void main(String[] args) {
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int[][] result = fill(image, 1, 1, 2);
        for (int[] row : result) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
