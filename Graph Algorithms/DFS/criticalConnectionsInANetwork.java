import java.util.*;

public class criticalConnectionsInANetwork {
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] disc = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();
        int timer = 0;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, disc, low, visited, adj, ans, connections, timer);
            }
        }

        return ans;
    }

    public static void dfs(int node, int parent, int[] disc, int[] low, boolean[] visited, List<List<Integer>> adj,
            List<List<Integer>> ans, List<List<Integer>> connections, int timer) {
        disc[node] = low[node] = timer++;
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) {
                continue;
            }

            if (!visited[neighbor]) {
                dfs(neighbor, node, disc, low, visited, adj, ans, connections, timer);
                low[node] = Math.min(low[node], low[neighbor]);

                if (low[neighbor] > disc[node]) {
                    ans.add(Arrays.asList(node, neighbor));
                }
            } else {
                low[node] = Math.min(low[node], disc[neighbor]);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));

        List<List<Integer>> ans = criticalConnections(n, connections);
        for (List<Integer> connection : ans) {
            System.out.println(connection.get(0) + " " + connection.get(1));
        }
    }
}