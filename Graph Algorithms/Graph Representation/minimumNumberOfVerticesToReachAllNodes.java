import java.util.*;

public class minimumNumberOfVerticesToReachAllNodes {
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        if (edges == null || edges.size() == 0)
            return new ArrayList<>();

        int indegree[] = new int[n];
        for (List<Integer> edge : edges) {
            int start = edge.get(0);
            int dest = edge.get(1);

            indegree[dest]++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(0, 2));
        edges.add(Arrays.asList(2, 5));
        edges.add(Arrays.asList(3, 4));
        edges.add(Arrays.asList(4, 2));

        System.out.println(findSmallestSetOfVertices(6, edges));
    }
}
