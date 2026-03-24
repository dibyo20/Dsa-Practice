import java.util.*;

public class detectCycleDirected {
    static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
    }

    public static boolean iscycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        boolean recStack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) { // this loop is to handle disconnected components
            if (!vis[i]) {
                if (iscycleUtil(graph, vis, recStack, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean iscycleUtil(ArrayList<Edge> graph[], boolean vis[], boolean recStack[], int curr) {
        vis[curr] = true;
        recStack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                if (iscycleUtil(graph, vis, recStack, e.dest)) {
                    return true;
                }
            } else if (recStack[e.dest]) {
                return true; // Cycle detected
            }
        }

        recStack[curr] = false; // Backtrack
        return false;
    }

    public static void main(String args[]) {
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println("Is there a cycle in the directed graph? " + iscycle(graph));
    }
}
