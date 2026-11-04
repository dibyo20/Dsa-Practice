import java.util.*;

public class countUnreachablePairsOfNodesInAnUndirectedGraph {
    public static long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        long result = 0;
        long remaining = n;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int size = dfs(i, adj, visited);
                remaining -= size;
                result += (long) (remaining * size);
            }
        }
        return result;
    }

    private static int dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        int size = 1;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                size += dfs(neighbor, adj, visited);
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = { { 0, 2 }, { 0, 5 }, { 2, 4 }, { 1, 6 }, { 5, 4 } };
        System.out.println(countPairs(n, edges));
    }
}
