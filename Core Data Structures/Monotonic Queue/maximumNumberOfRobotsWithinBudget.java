import java.util.*;

public class maximumNumberOfRobotsWithinBudget {
    public static int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int left = 0;
        int maxRobots = 0;
        long runningSum = 0;

        for (int right = 0; right < n; right++) {
            runningSum += runningCosts[right];
            while (!deque.isEmpty() && chargeTimes[deque.peekLast()] <= chargeTimes[right]) {
                deque.pollLast();
            }
            deque.offerLast(right);

            while(!deque.isEmpty() && (long) chargeTimes[deque.peekFirst()] + (right - left + 1L) * runningSum > budget) {
                if(deque.peekFirst() == left) {
                    deque.pollFirst();
                }
                runningSum -= runningCosts[left];
                left++;
            }
            maxRobots = Math.max(maxRobots, right - left + 1);
        }
        return maxRobots;
    }

    public static void main(String[] args) {
        int[] chargeTimes = {3, 6, 1, 3, 4};
        int[] runningCosts = {2, 1, 3, 4, 5};
        int budget = 25;
        System.out.println(maximumRobots(chargeTimes, runningCosts, budget));
    }
}
