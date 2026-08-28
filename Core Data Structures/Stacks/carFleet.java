import java.util.*;

public class carFleet {
    public static int fleet(int target, int[] position, int[] speed) {
        if (position.length == 0)
            return 0;

        if (position.length == 1)
            return 1;

        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        Stack<Double> stack = new Stack<>();
        int fleet = 0;
        for (int i = 0; i < n; i++) {
            double time = (double) (target - cars[i][0]) / cars[i][1];
            if (stack.isEmpty() || stack.peek() < time) {
                stack.push(time);
                fleet++;
            }
        }
        return fleet;
    }

    public static void main(String[] args) {
        int[] position = { 10, 8, 0, 5, 3 };
        int[] speed = { 2, 4, 1, 1, 3 };
        System.out.println(fleet(12, position, speed));
    }
}
