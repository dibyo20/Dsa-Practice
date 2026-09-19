import java.util.*;

public class maximumPerformanceOfATeam {
    public static class Engineer {
        int speed;
        int efficiency;

        public Engineer(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }
    }

    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Engineer[] engineers = new Engineer[n];
        for (int i = 0; i < n; i++) {
            engineers[i] = new Engineer(speed[i], efficiency[i]);
        }
        Arrays.sort(engineers, (a, b) -> Integer.compare(b.efficiency, a.efficiency));
        long speedSum = 0;
        long maxPerformance = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            Engineer curr = engineers[i];
            minHeap.offer(curr.speed);
            speedSum += curr.speed;
            if (minHeap.size() > k) {
                speedSum -= minHeap.poll();
            }
            long performance = speedSum * curr.efficiency;
            maxPerformance = Math.max(maxPerformance, performance);
        }
        return (int) (maxPerformance % 1_000_000_007);
    }

    public static void main(String[] args) {
        int n = 6;
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        int k = 2;
        System.out.println(maxPerformance(n, speed, efficiency, k));
    }
}
