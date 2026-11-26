public class removeMaxNumberOfEdgesToKeepGraphFullyTraversable {
    public static class DSU {
        public int[] parent;
        public int[] size;
        public int components;

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
            components = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) {
                return false;
            }

            if (size[px] < size[py]) {
                parent[px] = py;
                size[py] += size[px];
            } else {
                parent[py] = px;
                size[px] += size[py];
            }

            components--;
            return true;
        }
    }

    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);

        int removed = 0;

        for (int[] edge : edges) {
            if (edge[0] == 3) {
                int u = edge[1] - 1;
                int v = edge[2] - 1;

                boolean a = alice.union(u, v);
                boolean b = bob.union(u, v);

                if (!a && !b) {
                    removed++;
                }
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 1) {
                int u = edge[1] - 1;
                int v = edge[2] - 1;

                if (!alice.union(u, v)) {
                    removed++;
                }
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 2) {
                int u = edge[1] - 1;
                int v = edge[2] - 1;

                if (!bob.union(u, v)) {
                    removed++;
                }
            }
        }

        if (alice.components != 1 || bob.components != 1) {
            return -1;
        }

        return removed;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = { { 3, 1, 2 }, { 3, 2, 3 }, { 1, 1, 3 }, { 1, 2, 4 }, { 1, 1, 2 }, { 2, 3, 4 } };
        System.out.println(maxNumEdgesToRemove(n, edges));
    }

}
