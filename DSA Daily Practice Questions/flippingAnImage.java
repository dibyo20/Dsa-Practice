public class flippingAnImage {
    public static int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int left = 0, right = image[i].length - 1;
            while (left <= right) {
                int temp = image[i][left];
                image[i][left] = image[i][right] ^ 1;
                image[i][right] = temp ^ 1;
                left++;
                right--;
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
        int[][] ans = flipAndInvertImage(image);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}