import java.util.*;

public class redundantConnectionTwo {
    public static int[] dsuParent;
    public static int[] size;

    public static int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    public static boolean union(int u, int v, int[] parent, int[] size) {
        int pu = find(u, parent);
        int pv = find(v, parent);

        if (pu == pv) {
            return false;
        }

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }

        return true;
    }

    public static int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        int firstEdge = -1;
        int secondEdge = -1;

        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (parent[v] == 0) {
                parent[v] = i + 1;
            } else {
                firstEdge = parent[v] - 1;
                secondEdge = i;
            }
        }

        dsuParent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dsuParent[i] = i;
            size[i] = 1;
        }

        int cycleEdge = -1;
        for (int i = 0; i < n; i++) {
            if (i == secondEdge) {
                continue;
            }

            int u = edges[i][0];
            int v = edges[i][1];

            if (!union(u, v, dsuParent, size)) {
                cycleEdge = i;
            }
        }

        if (secondEdge == -1) {
            return edges[cycleEdge];
        }

        if (cycleEdge != -1) {
            return edges[firstEdge];
        }

        return edges[secondEdge];
    }

    public static void main(String[] args) {
        int[][] edges = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        System.out.println(Arrays.toString(findRedundantDirectedConnection(edges)));
    }
}
