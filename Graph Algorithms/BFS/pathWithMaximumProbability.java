import java.util.*;;

public class pathWithMaximumProbability {
    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        List<List<double[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new double[] { edges[i][1], succProb[i] });
            adj.get(edges[i][1]).add(new double[] { edges[i][0], succProb[i] });
        }

        double[] dist = new double[n];
        dist[start] = 1.0;
        pq.add(new double[] { start, 1.0 });
        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            int node = (int) curr[0];
            double prob = curr[1];
            if (prob < dist[node]) {
                continue;
            }

            if (node == end) {
                return prob;
            }

            for (double[] neighbor : adj.get(node)) {
                int adjNode = (int) neighbor[0];
                double edgeProb = neighbor[1];

                double newProb = prob * edgeProb;
                if (newProb > dist[adjNode]) {
                    dist[adjNode] = newProb;
                    pq.add(new double[] { adjNode, newProb });
                }
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
        double[] succProb = { 0.5, 0.5, 0.2 };
        int n = 3;
        int start = 0;
        int end = 2;

        System.out.println(maxProbability(n, edges, succProb, start, end));
    }
}
