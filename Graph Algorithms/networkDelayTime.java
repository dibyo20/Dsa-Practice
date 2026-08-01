import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class networkDelayTime {
    public static int networkDelay(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            graph.get(u).add(new int[] { v, wt });
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, k });

        while (!pq.isEmpty()) {
            int curr[] = pq.poll();

            int currDist = curr[0];
            int node = curr[1];

            if (currDist > dist[node]) {
                continue;
            }

            for (int[] neighbour : graph.get(node)) {
                int nextNode = neighbour[0];
                int weight = neighbour[1];

                int newDist = currDist + weight;

                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.offer(new int[] { newDist, nextNode });
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            answer = Math.max(answer, dist[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int n = 4;
        int k = 2;

        System.out.println(networkDelay(times, n, k));
    }
}
