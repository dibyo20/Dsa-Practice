import java.util.*;

public class taskScheduler {
    public static class Cooldown {
        int remaining;
        int availableTime;

        Cooldown(int remaining, int availableTime) {
            this.remaining = remaining;
            this.availableTime = availableTime;
        }
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int f : freq) {
            if (f > 0) {
                maxHeap.add(f);
            }
        }

        Queue<Cooldown> cooldown = new LinkedList<>();
        int intervals = 0;

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            intervals++;
            if (!cooldown.isEmpty() && cooldown.peek().availableTime <= intervals) {
                Cooldown task = cooldown.poll();
                maxHeap.offer(task.remaining);
            }
            if (!maxHeap.isEmpty()) {
                int remaining = maxHeap.poll() - 1;
                if (remaining > 0) {
                    cooldown.offer(new Cooldown(remaining, intervals + n + 1));
                }
            }
        }
        return intervals;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n)); 
    }
}
