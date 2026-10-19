public class kthAncestorOfATreeNode {
    public static class TreeAncestor {
        int[][] up;
        int LOG;

        public TreeAncestor(int n, int[] parent) {
            LOG = 1;
            while ((1 << LOG) <= n) {
                LOG++;
            }

            up = new int[n][LOG];

            for (int node = 0; node < n; node++) {
                up[node][0] = parent[node];
            }

            for (int j = 1; j < LOG; j++) {
                for (int node = 0; node < n; node++) {
                    int mid = up[node][j - 1];

                    if (mid == -1) {
                        up[node][j] = -1;
                    } else {
                        up[node][j] = up[mid][j - 1];
                    }
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            int bit = 0;

            while (k > 0 && node != -1) {
                if ((k & 1) == 1) {
                    node = up[node][bit];
                }
                k >>= 1;
                bit++;
            }
            return node;
        }
    }

    public static void main(String[] args) {
        int[] parent = {-1, 0, 0, 1, 1, 2, 2};
        int n = parent.length;

        TreeAncestor kthAncestor = new TreeAncestor(n, parent);
        System.out.println(kthAncestor.getKthAncestor(3, 1));
    }
}
