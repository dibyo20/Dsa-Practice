import java.util.*;

public class evaluateDivision {
    static class pair {
        String node;
        double weight;

        pair(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<pair>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(new pair(v, val));
            graph.get(v).add(new pair(u, 1.0 / val));
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                ans[i] = -1.0;
                continue;
            }

            Set<String> visited = new HashSet<>();
            ans[i] = dfs(src, dest, graph, visited);
        }
        return ans;
    }

    private static double dfs(String src, String dest, Map<String, List<pair>> graph, Set<String> visited) {
        if (src.equals(dest)) {
            return 1.0;
        }

        visited.add(src);

        for (pair nbr : graph.get(src)) {
            if (!visited.contains(nbr.node)) {
                double result = dfs(nbr.node, dest, graph, visited);

                if (result != -1.0) {
                    return nbr.weight * result;
                }
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c"));

        double[] values = { 2.0, 3.0 };

        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("x", "x"));

        System.out.println(Arrays.toString(calcEquation(equations, values, queries)));
    }
}
