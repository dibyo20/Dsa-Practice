public class trappingRainWater {
    public static int trappedWater(int[] heights) {
        int n = heights.length;

        if (n < 2) {
            return 0;
        }

        int leftMax[] = new int[n];
        int rightMax[] = new int[n];
        int waterTrapped = 0;

        leftMax[0] = heights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }

        rightMax[n - 1] = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }

        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            waterTrapped += waterLevel - heights[i];
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        int[] heights = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trappedWater(heights));
    }
}
