import java.util.*;

public class parallelCoursesThree {
    public static int minimumSemesters(int n, int[][] relations, int[] time) {
        int[] indegree = new int[n + 1];
        List<List<Integer>> adj = new ArrayList<>();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = time[i - 1];
        }

        for (int[] relation : relations) {
            indegree[relation[1]]++;
            adj.get(relation[0]).add(relation[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int ans = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans = Math.max(ans, dp[curr]);
            for (int neighbor : adj.get(curr)) {
                dp[neighbor] = Math.max(dp[neighbor], dp[curr] + time[neighbor - 1]);
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] time = { 1, 2, 3, 4, 5 };
        int[][] relations = { { 1, 5 }, { 2, 5 }, { 3, 5 }, { 3, 4 }, { 4, 5 } };
        int n = 5;
        System.out.println(minimumSemesters(n, relations, time));
    }
}
