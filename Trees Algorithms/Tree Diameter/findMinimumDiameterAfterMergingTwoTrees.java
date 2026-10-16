import java.util.*;

public class findMinimumDiameterAfterMergingTwoTrees {
    public static int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n = edges1.length;
        int m = edges2.length;

        @SuppressWarnings("unchecked")
        List<Integer>[] graph1 = new ArrayList[n + 1];
        @SuppressWarnings("unchecked")
        List<Integer>[] graph2 = new ArrayList[m + 1];

        for (int i = 0; i <= n; i++) {
            graph1[i] = new ArrayList<>();
        }

        for (int i = 0; i <= m; i++) {
            graph2[i] = new ArrayList<>();
        }

        for (int[] edge : edges1) {
            int u = edge[0];
            int v = edge[1];

            graph1[u].add(v);
            graph1[v].add(u);
        }

        for (int[] edge : edges2) {
            int u = edge[0];
            int v = edge[1];

            graph2[u].add(v);
            graph2[v].add(u);
        }

        int d1 = findDiameter(graph1);
        int d2 = findDiameter(graph2);
        int r1 = (d1 + 1) / 2;
        int r2 = (d2 + 1) / 2;

        return Math.max(d1, Math.max(d2, r1 + r2 + 1));

    }

    private static int findDiameter(List<Integer>[] graph) {
        int farthest = bfs(graph, 0)[0];
        return bfs(graph, farthest)[1];
    }

    private static int[] bfs(List<Integer>[] graph, int start) {
        int n = graph.length;

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        int farthestNode = start;
        int maxDistance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                farthestNode = node;

                for (int neighbor : graph[node]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }

            if (!queue.isEmpty()) {
                maxDistance++;
            }
        }

        return new int[] { farthestNode, maxDistance };
    }

    public static void main(String[] args) {
        int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 0, 3 } };
        int[][] edges2 = { { 0, 1 } };
        System.out.println(minimumDiameterAfterMerge(edges1, edges2));
    }
}