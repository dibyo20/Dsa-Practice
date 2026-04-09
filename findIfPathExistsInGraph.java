import java.util.ArrayList;
import java.util.List;

public class findIfPathExistsInGraph {
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];

        return dfs(source, destination, adj, visited);
    }

    private static boolean dfs(int node, int destination, List<List<Integer>> adj, boolean[] visited) {
        if (node == destination)
            return true;

        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, destination, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
        int source = 0, destination = 2;
        System.out.println(validPath(n, edges, source, destination)); 
    }
}
