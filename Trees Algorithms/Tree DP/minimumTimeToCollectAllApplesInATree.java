import java.util.*;

public class minimumTimeToCollectAllApplesInATree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }

    public static int time;

    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        time = 0;

        dfs(adj, 0, -1, hasApple);

        return time;
    }

    public static boolean dfs(List<List<Integer>> adj, int node, int parent, List<Boolean> hasApple) {
        boolean containsApple = hasApple.get(node);

        for (int child : adj.get(node)) {
            if (child == parent) {
                continue;
            }

            boolean childContainsApple = dfs(adj, child, node, hasApple);

            if (childContainsApple) {
                containsApple = true;
                time += 2;
            }
        }
        return containsApple;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
        List<Boolean> hasApple = Arrays.asList(false, false, true, false, true, true, false);

        System.out.println(minTime(n, edges, hasApple));
    }
}
