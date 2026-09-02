import java.util.*;

public class maxValueOfEquation {
    public static int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;
        for (int j = 0; j < points.length; j++) {
            int xj = points[j][0];
            int yj = points[j][1];

            while (!deque.isEmpty() && xj - points[deque.peekFirst()][0] > k) {
                deque.pollFirst();
            }

            if (!deque.isEmpty()) {
                int i = deque.peekFirst();
                int value = points[i][1] - points[i][0] + xj + yj;
                ans = Math.max(ans, value);
            }

            while (!deque.isEmpty() && points[deque.peekLast()][1] - points[deque.peekLast()][0] <= yj - xj) {
                deque.pollLast();
            }

            deque.offerLast(j);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = { { 1, 3 }, { 2, 0 }, { 5, 10 }, { 6, -10 } };
        int k = 1;
        System.out.println(findMaxValueOfEquation(points, k));
    }
}
