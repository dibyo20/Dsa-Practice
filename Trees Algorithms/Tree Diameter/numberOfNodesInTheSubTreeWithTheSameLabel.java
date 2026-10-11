import java.util.*;

public class numberOfNodesInTheSubTreeWithTheSameLabel {
    public static int[] ans;
    public static String labels;
    public static List<Integer>[] adj;

    public static  int[] countSubTrees(int n, int[][] edges, String labels) {
        numberOfNodesInTheSubTreeWithTheSameLabel.labels = labels;
        ans = new int[n];
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[n];
        adj = graph;

        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        dfs(0, -1);

        return ans;
    }

    public static  int[] dfs(int node, int parent){
        int[] freq = new int[26];

        freq[labels.charAt(node) - 'a']++;

        for(int child : adj[node]){
            if(child == parent){
                continue;
            }

            int[] childFreq = dfs(child, node);

            for(int i=0; i<26; i++){
                freq[i] += childFreq[i];
            }
        }

        ans[node] = freq[labels.charAt(node) - 'a'];
        return freq;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        String labels = "abaedcd";
        int[] ans = countSubTrees(n, edges, labels);
        System.out.println(Arrays.toString(ans));
    }
}
