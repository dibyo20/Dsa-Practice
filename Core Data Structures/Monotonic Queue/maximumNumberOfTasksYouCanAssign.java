import java.util.*;

public class maximumNumberOfTasksYouCanAssign {
    public static int maximumTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int n = tasks.length;
        int m = workers.length;
        int low = 0, high = Math.min(n, m);
        int answer = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canAssign(tasks, workers, pills, strength, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }

    private static boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int m = workers.length;
        int workIndex = m - 1;
        int usedPills = 0;

        for (int i = k - 1; i >= 0; i--) {
            int task = tasks[i];
            while (workIndex >= m - k && (long) workers[workIndex] + strength >= task) {
                deque.offerLast(workers[workIndex]);
                workIndex--;
            }

            if (deque.isEmpty()) {
                return false;
            }

            if (deque.peekFirst() >= task) {
                deque.pollFirst();
            } else {
                if (usedPills == pills) {
                    return false;
                }
                deque.pollLast();
                usedPills++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] tasks = { 3, 2, 1 };
        int[] workers = { 0, 3, 3 };
        int pills = 1;
        int strength = 1;
        System.out.println(maximumTaskAssign(tasks, workers, pills, strength));
    }
}