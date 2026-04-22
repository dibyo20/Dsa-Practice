import java.util.*;

public class possibleBipartition {
    public static boolean isPossible(int n, int[][] dislikes) {
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] d : dislikes) {
            graph[d[0]].add(d[1]);
            graph[d[1]].add(d[0]);
        }

        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                if (!bfs(i, graph, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean bfs(int start, List<Integer>[] graph, int[] color) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int nei : graph[node]) {
                if (color[nei] == -1) {
                    color[nei] = 1 - color[node];
                    q.offer(nei);
                } else if (color[nei] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] dislikes = { { 1, 2 }, { 1, 3 }, { 2, 4 } };
        System.out.println(isPossible(n, dislikes));
    }
}
