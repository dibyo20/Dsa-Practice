import java.util.*;

public class timeNeededToInformAllEmployees {
    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n == 1)
            return informTime[0];

        @SuppressWarnings("unchecked")
        List<Integer>[] subordinates = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            subordinates[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1)
                subordinates[manager[i]].add(i);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { headID, 0 });
        int ans = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currID = curr[0];
            int currTime = curr[1];
            ans = Math.max(ans, currTime);
            for (int sub : subordinates[currID]) {
                queue.offer(new int[] { sub, currTime + informTime[currID] });
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 6;
        int headId = 2;
        int[] manager = { 2, 2, -1, 2, 2, 2 };
        int[] informTime = { 0, 0, 1, 0, 0, 0 };
        System.out.println(numOfMinutes(n, headId, manager, informTime));
    }
}
