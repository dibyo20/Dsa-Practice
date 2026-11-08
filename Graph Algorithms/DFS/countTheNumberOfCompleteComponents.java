import java.util.ArrayList;

public class countTheNumberOfCompleteComponents {
    public static int vertices;
    public static int edge;

    public static int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                vertices = 0;
                edge = 0;
                dfs(graph, visited, i);

                edge /= 2;
                int requirement = vertices * (vertices - 1) / 2;
                if (edge == requirement) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        vertices++;
        edge += graph.get(node).size();
        for (int nbr : graph.get(node)) {
            if (!visited[nbr]) {
                dfs(graph, visited, nbr);
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 3, 4 } };
        System.out.println(countComponents(n, edges));
    }
}
