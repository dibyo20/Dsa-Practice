import java.util.*;

public class shortestCycleInAGraph {
    public static int findShortestCycle(int[][] edges, int n) {
        @SuppressWarnings("unchecked")
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] dist = new int[n];
            int[] parent = new int[n];
            Arrays.fill(dist, -1);
            Arrays.fill(parent, -1);

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            dist[i] = 0;

            while (!q.isEmpty()) {
                int curr = q.poll();
                for (int nbr : adj[curr]) {
                    if (dist[nbr] == -1) {
                        dist[nbr] = dist[curr] + 1;
                        parent[nbr] = curr;
                        q.add(nbr);
                    } else if (parent[curr] != nbr) {
                        ans = Math.min(ans, dist[curr] + dist[nbr] + 1);
                    }
                }
            }
            if (ans == 3) {
                return 3;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 3 } };
        System.out.println(findShortestCycle(edges, 7));
    }
}
