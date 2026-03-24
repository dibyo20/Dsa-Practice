import java.util.*;

public class detectCycleUndirectedBFS {

    static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[2].add(new Edge(2, 0));

        graph[0].add(new Edge(0, 3));
        graph[3].add(new Edge(3, 0));

        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        int[] parent = new int[graph.length];
        Arrays.fill(parent, -1);

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (bfs(graph, vis, parent, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean bfs(ArrayList<Edge>[] graph, boolean[] vis, int[] parent, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;

        while (!q.isEmpty()) {
            int curr = q.remove();

            for (Edge e : graph[curr]) {
                if (!vis[e.dest]) {
                    vis[e.dest] = true;
                    parent[e.dest] = curr;
                    q.add(e.dest);
                } else if (parent[curr] != e.dest) {
                    return true; // cycle found
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);

        System.out.println("Cycle detected: " + detectCycle(graph));
    }
}
