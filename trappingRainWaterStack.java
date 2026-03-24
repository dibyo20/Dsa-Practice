import java.util.Stack;

public class trappingRainWaterStack {

    public static int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int water = 0;

        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int valley = stack.pop();

                if (stack.isEmpty())
                    break;

                int left = stack.peek();
                int width = i - left - 1;
                int boundedHeight = Math.min(height[left], height[i]) - height[valley];

                water += width * boundedHeight;
            }

            stack.push(i);
        }
        return water;
    }

    public static void main(String[] args) {
        // int heights[] = { 4, 2, 0, 6, 3, 2, 5 };
        int heights[] = { 7, 0, 4, 2, 5, 0, 6, 4, 0, 6, };
        System.out.println(trap(heights));
    }
}
