public class trappingrainwater {
    public static void trappedRainWater(int heights[]) {
        int n = heights.length;
        if (n < 2)
            return;

        int leftMax[] = new int[n];
        int rightMax[] = new int[n];
        int waterTrapped = 0;

        // leftMax array
        leftMax[0] = heights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }

        // rightMax array
        rightMax[n - 1] = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }

        // water trapped
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            waterTrapped += waterLevel - heights[i];
        }

        System.out.println("Water trapped: " + waterTrapped);
    }

    public static void main(String[] args) {
        // int heights[] = { 4, 2, 0, 6, 3, 2, 5 };
        int heights[] = { 7, 0, 4, 2, 5, 0, 6, 4, 0, 6, };
        trappedRainWater(heights);
    }
}
