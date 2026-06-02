import java.util.*;

public class minimumHeightTrees {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int degree[] = new int[n];

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.offer(i);
            }
        }

        int remainingNode = n;

        while (remainingNode > 2) {
            int size = q.size();
            remainingNode -= size;

            for (int i = 0; i < size; i++) {
                int node = q.poll();

                for (int neighbor : adj.get(node)) {
                    degree[neighbor]--;

                    if (degree[neighbor] == 1) {
                        q.offer(neighbor);
                    }
                }
            }
        }
        return new ArrayList<>(q);
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = { { 1, 0 }, { 1, 2 }, { 1, 3 } };

        System.out.println(findMinHeightTrees(n, edges));
    }
}
