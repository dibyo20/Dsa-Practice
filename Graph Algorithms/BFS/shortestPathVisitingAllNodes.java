import java.util.*;;

public class shortestPathVisitingAllNodes {
    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int target = (1 << n) - 1;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            int mask = 1 << i;
            q.offer(new int[] { i, mask, 0 });
            visited[i][mask] = true;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int mask = cur[1];
            int dist = cur[2];

            if (mask == target)
                return dist;

            for (int neighbour : graph[node]) {
                int newMask = mask | (1 << neighbour);
                if (!visited[neighbour][newMask]) {
                    q.offer(new int[] { neighbour, newMask, dist + 1 });
                    visited[neighbour][newMask] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] graph = { { 1, 2, 3 }, { 0 }, { 0 }, { 0 } };
        System.out.println(shortestPathLength(graph));
    }
}
