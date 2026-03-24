import java.util.*;

public class cheapestFlightsKStops {
    static class Edge {
        int src, dest, cost;

        public Edge(int src, int dest, int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int flights[][]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int cost = flights[i][2];
            Edge e = new Edge(src, dest, cost);
            graph[src].add(e);
        }
    }

    static class Info {
        int v, cost, stops;

        public Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static int cheapestFlight(int n, int flights[][], int src, int dst, int k) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph, flights);

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k) {
                break;
            }

            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int v = e.dest;
                int cost = e.cost;

                if (curr.cost + cost < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + cost;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }

        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }

    public static void main(String args[]) {
        int n = 4;
        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0;
        int dst = 3;
        int k = 1;

        System.out.println("Cheapest flight cost from " + src + " to " + dst + " with at most " + k + " stops is: " +
                cheapestFlight(n, flights, src, dst, k));
    }
}
