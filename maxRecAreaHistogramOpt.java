import java.util.Stack;

public class maxRecAreaHistogramOpt {

    public static void maxArea(int heights[]) { // TC: O(n)
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        System.out.println("Maximum area in histogram = " + maxArea);
    }

    public static void main(String args[]) {
        int arr[] = { 2, 1, 5, 6, 2, 3 };
        maxArea(arr);
    }
}
