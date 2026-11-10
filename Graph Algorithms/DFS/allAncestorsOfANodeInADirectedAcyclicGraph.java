import java.util.*;

public class allAncestorsOfANodeInADirectedAcyclicGraph {
    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            indegree[v]++;
        }

        List<Set<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestors.add(new HashSet<>());
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                ancestors.get(v).add(u);

                ancestors.get(v).addAll(ancestors.get(u));

                indegree[v]--;
                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>(ancestors.get(i));
            Collections.sort(list);
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 8;
        int[][] edges = {{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}};
        System.out.println(getAncestors(n, edges));
    }
}
