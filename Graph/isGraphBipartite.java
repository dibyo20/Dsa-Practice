public class isGraphBipartite {
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            colors[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (!dfs(graph, i, colors, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(int[][] graph, int node, int[] colors, int currColor) {
        colors[node] = currColor;

        for (int neighbour : graph[node]) {
            if (currColor == -1) {
                if (!dfs(graph, neighbour, colors, 1 - currColor)) {
                    return false;
                }
            } else if (colors[neighbour] == currColor) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println(isBipartite(graph));
    }
}
