import java.util.*;

public class numberOfOperationsToMakeNetworkConnected {
    public static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1)
            return -1;

        @SuppressWarnings ("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : connections) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int components = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                components++;
            }
        }

        return components - 1;
    }

    private static void dfs(ArrayList<Integer>[] graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        System.out.println(makeConnected(n, connections));
    }
}
