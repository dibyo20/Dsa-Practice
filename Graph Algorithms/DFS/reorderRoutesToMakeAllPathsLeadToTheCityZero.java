import java.util.*;

public class reorderRoutesToMakeAllPathsLeadToTheCityZero {
    public static int minReorder(int n, int[][] connections) {
        @SuppressWarnings ("unchecked")
        ArrayList<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : connections){
            graph[edge[0]].add(new int[]{edge[1], 1});
            graph[edge[1]].add(new int[]{edge[0], 0});
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    public static int dfs(int node, ArrayList<int[]>[] graph, boolean[] visited){
        visited[node] = true;
        int count = 0;
        for(int[] edge : graph[node]){
            int neighbour = edge[0];
            int cost = edge[1];

            if(!visited[neighbour]){
                count += cost;
                count += dfs(neighbour, graph, visited);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        int n = 6;
        System.out.println(minReorder(n, connections));
    }
}
