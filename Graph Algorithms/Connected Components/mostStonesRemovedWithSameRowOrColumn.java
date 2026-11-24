public class mostStonesRemovedWithSameRowOrColumn {
    public static int[] parent;
    public static int[] size;

    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) {
            return;
        }

        if (size[px] < size[py]) {
            parent[px] = py;
            size[py] += size[px];
        } else {
            parent[py] = px;
            size[px] += size[py];
        }
    }

    public static int removeStones(int[][] stones) {
        int n = stones.length;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j);
                }
            }
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (find(i) == i) {
                components++;
            }
        }
        return n - components;
    }

    public static void main(String[] args) {
        int[][] stones = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };
        System.out.println(removeStones(stones));
    }
}
