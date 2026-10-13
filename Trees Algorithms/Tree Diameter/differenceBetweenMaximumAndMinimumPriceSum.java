import java.util.ArrayList;
import java.util.List;

public class differenceBetweenMaximumAndMinimumPriceSum {
    public static List<Integer>[] adj;
    public static int[] price;
    public static long[] down, up;

    public static long maxOutput(int n, int[][] edges, int[] price) {
        differenceBetweenMaximumAndMinimumPriceSum.price = price;
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

        down = new long[n];
        up = new long[n];

        dfsDown(0, -1);
        dfsUp(0, -1);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, Math.max(down[i], up[i]) - price[i]);
        }

        return ans;
    }

    public static void dfsDown(int u, int parent) {
        down[u] = price[u];

        for (int v : adj[u]) {
            if (v == parent)
                continue;

            dfsDown(v, u);
            down[u] = Math.max(down[u], price[u] + down[v]);
        }
    }

    public static void dfsUp(int u, int parent) {
        long largest = 0;
        long secondLargest = 0;
        int largestChild = -1;

        for (int v : adj[u]) {
            if (v == parent)
                continue;

            if (down[v] > largest) {
                secondLargest = largest;
                largest = down[v];
                largestChild = v;
            } else if (down[v] > secondLargest) {
                secondLargest = down[v];
            }
        }

        for (int v : adj[u]) {
            if (v == parent)
                continue;

            long bestSibling = (v == largestChild) ? secondLargest : largest;
            long bestOutsideV = Math.max(up[u], (long) price[u] + bestSibling);

            up[v] = price[v] + bestOutsideV;
            dfsUp(v, u);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[] price = { 9, 8, 7, 6, 10, 5 };
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 1, 3 }, { 3, 4 }, { 3, 5 } };

        long ans = maxOutput(n, edges, price);
        System.out.println(ans);
    }
}
