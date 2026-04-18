import java.util.*;

public class minimumHeightTrees {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Arrays.asList(0);

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int degree[] = new int[n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        int remainingNode = n;

        while (remainingNode > 2) {
            int size = queue.size();
            remainingNode -= size;

            for (int i = 0; i < size; i++) {
                int leaf = queue.poll();

                for (int neighbor : adj.get(leaf)) {
                    degree[neighbor]--;

                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 }
        };
        System.out.println(findMinHeightTrees(n, edges));
    }
}
