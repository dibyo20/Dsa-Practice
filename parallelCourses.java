import java.util.*;

public class parallelCourses {
    public static int coursesTaken(int n, int[][] courses) {
        if (n == 0)
            return 0;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int degree[] = new int[n];

        for (int[] course : courses) {
            int a = course[0];
            int b = course[1];

            adj.get(b).add(a); // Since it is a directed graph.
            degree[a]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0)
                q.offer(i);
        }

        int semesters = 0;
        int completed = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int course = q.poll();
                completed++;

                for (int neighbour : adj.get(course)) {
                    degree[neighbour]--;
                    if (degree[neighbour] == 0)
                        q.offer(neighbour);
                }
            }
            semesters++;
        }
        return completed == n ? semesters : -1;
    }

    public static void main(String[] args) {
        int[][] courses = { { 1, 2 }, { 0, 2 } };
        System.out.println(coursesTaken(3, courses));
    }
}
