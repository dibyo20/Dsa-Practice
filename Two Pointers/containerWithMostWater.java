public class containerWithMostWater {
    public static int maxArea(int[] heights) {
        int lp = 0;
        int rp = heights.length - 1;
        int maxWater = 0;

        while (lp < rp) {
            int height = Math.min(heights[lp], heights[rp]);
            int width = rp - lp;
            maxWater = Math.max(maxWater, height * width);
            if (heights[lp] < heights[rp]) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        int[] heights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(heights));
    }
}
