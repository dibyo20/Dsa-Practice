import java.util.*;

public class longestCycleInAGraph {
    public static int longestCycleDFSTimestampsApproach(int[] edges) {
        int n = edges.length;
        int[] visited = new int[n];
        int timer = 0;
        int maxLength = -1;

        for (int i = 0; i < n; i++) {
            if (visited[i] != 0)
                continue;

            int node = i;
            int startTime = timer;

            while (node != -1 && visited[node] == 0) {
                visited[node] = ++timer;
                node = edges[node];
            }

            if (node != -1 && visited[node] > startTime) {
                int cycleLength = timer - visited[node] + 1;
                maxLength = Math.max(maxLength, cycleLength);
            }
        }
        return maxLength;
    }

    public static int longestCycleKahnAlgorithm(int[] edges) {
        int n = edges.length;
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            if (edges[i] != -1) {
                indegree[edges[i]]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            int next = edges[node];

            if (next != -1) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int maxLength = -1;
        for (int i = 0; i < n; i++) {
            if (indegree[i] > 0 && !visited[i]) {
                int node = i;
                int length = 0;

                while (!visited[node]) {
                    visited[node] = true;
                    length++;
                    node = edges[node];
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] edges = { 3, 3, 4, 2, 3 };
        System.out.println(longestCycleDFSTimestampsApproach(edges));
        System.out.println(longestCycleKahnAlgorithm(edges));
    }
}
