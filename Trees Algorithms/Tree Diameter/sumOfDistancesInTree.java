import java.util.*;

public class sumOfDistancesInTree {
    public static int[] count;
    public static int[] ans;
    public static List<Integer>[] adj;

    public static int[] sumOfDist(int n, int[][] edges) {
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[n];
        adj = graph;

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        count = new int[n];
        ans = new int[n];

        dfs1(0, -1, 0);
        dfs2(0, -1, n);

        return ans;
    }

    public static void dfs1(int node, int parent, int depth) {
        count[node] = 1;
        ans[0] += depth;

        for (int child : adj[node]) {
            if (child == parent) {
                continue;
            }

            dfs1(child, node, depth + 1);
            count[node] += count[child];
        }
    }

    public static void dfs2(int node, int parent, int n) {
        for (int child : adj[node]) {
            if (child == parent) {
                continue;
            }

            ans[child] = ans[node] + n - 2 * count[child];
            dfs2(child, node, n);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 }, { 2, 5 } };
        int[] ans = sumOfDist(n, edges);
        System.out.println(Arrays.toString(ans));
    }
}