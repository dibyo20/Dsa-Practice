public class findTheTownJudge {
    public static int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];

        for(int[] t : trust) {
            int a = t[0];
            int b = t[1];

            outdegree[a]++;
            indegree[b]++;
        }

        for(int i = 1; i <= n; i++) {
            if(indegree[i] == n - 1 && outdegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] trust = {{1,3},{2,3}};
        int n = 3;
        System.out.println(findJudge(n, trust));
    }
}
