public class redundantConnection {

    static class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // path compression
            }
            return parent[x];
        }

        boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv) {
                return false; // cycle detected
            }

            parent[pu] = pv;
            return true;
        }
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);

        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return edge; 
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[][] edges = {
                { 1, 2 },
                { 1, 3 },
                { 2, 3 }
        };
        int[] ans = findRedundantConnection(edges);
        System.out.println("Edge to remove: [" + ans[0] + ", " + ans[1] + "]");
    }
}