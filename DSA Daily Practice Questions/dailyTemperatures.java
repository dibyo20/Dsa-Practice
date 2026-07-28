import java.util.*;

public class dailyTemperatures {
    public static int[] dailyTemp(int[] temperatures) {
        Deque<Integer> s = new ArrayDeque<>();
        int nxtWarmerDay[] = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nxtWarmerDay[i] = 0;
            } else {
                nxtWarmerDay[i] = s.peek() - i;
            }

            s.push(i);
        }

        return nxtWarmerDay;
    }

    public static void main(String[] args) {
        int temperatures[] = { 73, 74, 75, 71, 69, 72, 76, 73 };
        System.out.println(Arrays.toString(dailyTemp(temperatures)));
    }
}
