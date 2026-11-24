public class regionsCutBySlashes {
    public static int[] parent;
    public static int[] size;
    public static int count;

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

        count--;
    }

    public static int regions(String[] grid) {
        int n = grid.length;
        parent = new int[4 * n * n];
        size = new int[4 * n * n];
        count = 4 * n * n;

        for (int i = 0; i < 4 * n * n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                int base = 4 * (i * n + j);
                int top = base;
                int right = base + 1;
                int bottom = base + 2;
                int left = base + 3;

                if (ch == ' ') {
                    union(top, right);
                    union(right, bottom);
                    union(bottom, left);
                } else if (ch == '/') {
                    union(top, left);
                    union(right, bottom);
                } else if (ch == '\\') {
                    union(top, right);
                    union(bottom, left);
                }

                if (j + 1 < n) {
                    int neighbourBase = 4 * (i * n + (j + 1));
                    union(right, neighbourBase + 3);
                }

                if (i + 1 < n) {
                    int neighbourBase = 4 * ((i + 1) * n + j);
                    union(bottom, neighbourBase);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] grid = { "/\\", "\\/" };
        System.out.println(regions(grid));
    }
}
