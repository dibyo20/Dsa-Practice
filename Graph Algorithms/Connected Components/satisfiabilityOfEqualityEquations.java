public class satisfiabilityOfEqualityEquations {
    public static int[] parent = new int[26];
    public static int[] size = new int[26];

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

    public static boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int a = eq.charAt(0) - 'a';
                int b = eq.charAt(3) - 'a';
                union(a, b);
            }
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int a = eq.charAt(0) - 'a';
                int b = eq.charAt(3) - 'a';

                if (find(a) == find(b)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String[] equations = {"a==b", "b!=a"};
        System.out.println(equationsPossible(equations));
    }
}
