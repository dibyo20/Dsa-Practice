import java.util.*;

public class findEventualSafeStates {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;
        int state[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, state))
                ans.add(i);
        }

        return ans;
    }

    private static boolean dfs(int node, int[][] graph, int[] state) {
        if (state[node] == 2) {
            return true;
        }

        if (state[node] == 3) {
            return false;
        }

        if (state[node] == 1) {
            return false;
        }

        state[node] = 1;

        for (int nbr : graph[node]) {
            if (!dfs(nbr, graph, state)) {
                state[node] = 3;
                return false;
            }
        }

        state[node] = 2;
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
        System.out.println(eventualSafeNodes(graph));
    }
}
