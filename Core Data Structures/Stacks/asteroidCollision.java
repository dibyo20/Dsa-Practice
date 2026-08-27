import java.util.*;

public class asteroidCollision {
    public static int[] Collision(int[] asteroids) {
        int[] stack = new int[asteroids.length];
        int top = -1;

        for (int asteroid : asteroids) {
            boolean destroyed = false;
            while (top >= 0 && stack[top] > 0 && asteroid < 0) {
                if (stack[top] < -asteroid) {
                    top--;
                } else if (stack[top] == -asteroid) {
                    top--;
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack[++top] = asteroid;
            }
        }
        return Arrays.copyOf(stack, top + 1);
    }

    public static void main(String[] args) {
        int[] asteroids = { 5, 10, -5 };
        int[] result = Collision(asteroids);
        System.out.println(Arrays.toString(result));
    }
}
