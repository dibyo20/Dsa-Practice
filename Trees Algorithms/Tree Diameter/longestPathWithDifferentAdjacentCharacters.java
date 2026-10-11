import java.util.*;

public class longestPathWithDifferentAdjacentCharacters {
    public static List<Integer>[] adj;
    public static String s;
    public static int globalMax = 1;

    public static int longestPath(int[] parent, String s) {
        longestPathWithDifferentAdjacentCharacters.s = s;
        int n = parent.length;
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[n];
        adj = graph;
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }
        dfs(0);
        return globalMax;
    }

    private static int dfs(int node) {
        int longest1 = 0;
        int longest2 = 0;

        for (int child : adj[node]) {
            int childLength = dfs(child);

            if (s.charAt(node) == s.charAt(child)) {
                continue;
            }

            if (childLength > longest1) {
                longest2 = longest1;
                longest1 = childLength;
            } else if (childLength > longest2) {
                longest2 = childLength;
            }
        }

        globalMax = Math.max(globalMax, 1 + longest1 + longest2);
        return 1 + longest1;
    }

    public static void main(String[] args) {
        int[] parent = { -1, 0, 0, 1, 1, 2};
        String s = "abacbe";
        System.out.println(longestPath(parent, s));
    }
}
