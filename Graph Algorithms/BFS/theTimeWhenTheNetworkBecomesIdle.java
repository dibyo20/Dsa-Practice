import java.util.*;

public class theTimeWhenTheNetworkBecomesIdle {
    public static int networkBecomesIdle(int[][] edges, int[] patience) {
        List<List<Integer>> adj = new ArrayList<>();
        int ans = 0;

        for (int i = 0; i < patience.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] dist = new int[patience.length];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        dist[0] = 0;
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int neighbor : adj.get(curr)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[curr] + 1;
                    q.add(neighbor);
                }
            }
        }

        for (int i = 0; i < patience.length; i++) {
            if (i == 0) {
                continue;
            }

            int rtt = 2 * dist[i];
            int lastSend = (rtt - 1) / patience[i] * patience[i];
            int lastReply = lastSend + rtt;
            int idleTime = lastReply + 1;
            ans = Math.max(ans, idleTime);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 1, 2 } };
        int[] patience = { 0, 2, 1 };
        System.out.println(networkBecomesIdle(edges, patience));
    }
}
