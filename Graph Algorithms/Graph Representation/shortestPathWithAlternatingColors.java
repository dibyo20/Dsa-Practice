import java.util.*;

public class shortestPathWithAlternatingColors {
    public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> red = new ArrayList<>();
        List<List<Integer>> blue = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            red.add(new ArrayList<>());
            blue.add(new ArrayList<>());
        }

        for (int[] edge : redEdges) {
            red.get(edge[0]).add(edge[1]);
        }

        for (int[] edge : blueEdges) {
            blue.get(edge[0]).add(edge[1]);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        boolean[][] visited = new boolean[n][2];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, -1});

        visited[0][0] = true;
        visited[0][1] = true;
        ans[0] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int dist = curr[1];
            int lastColor = curr[2];

            if (lastColor != 0) {
                for (int neighbor : red.get(node)) {
                    if (!visited[neighbor][0]) {
                        visited[neighbor][0] = true;

                        if (ans[neighbor] == -1) {
                            ans[neighbor] = dist + 1;
                        }

                        queue.offer(new int[]{
                            neighbor, dist + 1, 0
                        });
                    }
                }
            }

            if (lastColor != 1) {
                for (int neighbor : blue.get(node)) {
                    if (!visited[neighbor][1]) {
                        visited[neighbor][1] = true;

                        if (ans[neighbor] == -1) {
                            ans[neighbor] = dist + 1;
                        }

                        queue.offer(new int[]{
                            neighbor, dist + 1, 1
                        });
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] redEdges = {{0, 1}, {1, 2}};
        int[][] blueEdges = {};

        int[] result = shortestAlternatingPaths(n, redEdges, blueEdges);
        System.out.println(Arrays.toString(result));
    }
}
