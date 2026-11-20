import java.util.*;

public class divideNodesIntoTheMaximumNumberOfGroups {
    public static int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] color = new int[n];
        Arrays.fill(color, -1);
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (color[i] != -1)
                continue;

            List<Integer> componentNodes = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            color[i] = 0;

            while (!q.isEmpty()) {
                int node = q.poll();
                componentNodes.add(node);
                for (int neighbor : adj.get(node)) {
                    if (color[neighbor] == -1) {
                        color[neighbor] = 1 - color[node];
                        q.offer(neighbor);
                    } else if (color[neighbor] == color[node]) {
                        return -1;
                    }
                }
            }

            int componentMax = 0;
            for (int node : componentNodes) {
                int groups = bfs(adj, node);
                componentMax = Math.max(componentMax, groups);
            }
            answer += componentMax;
        }
        return answer;
    }

    private static int bfs(List<List<Integer>> adj, int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        q.offer(start);
        visited[start] = true;
        int groups = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            groups++;

            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                for (int neighbor : adj.get(curr)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        q.offer(neighbor);
                    }
                }
            }
        }
        return groups;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                { 1, 2 }, { 1, 4 }, { 1, 5 },
                { 2, 6 }, { 2, 3 }, { 4, 6 }
        };
        System.out.println(magnificentSets(n, edges));
    }
}
