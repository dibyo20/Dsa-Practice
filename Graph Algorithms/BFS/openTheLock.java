import java.util.*;

public class openTheLock {
    public static int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        if (dead.contains("0000")) {
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer("0000");
        visited.add("0000");

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curr = q.poll();

                if (curr.equals(target)) {
                    return steps;
                }

                for (String neighbor : getNeighbors(curr)) {
                    if (!dead.contains(neighbor) && !visited.contains(neighbor)) {
                        q.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private static List<String> getNeighbors(String s) {
        List<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];

            arr[i] = (char) ((ch - '0' + 1) % 10 + '0'); // To increase the number to next number.
            res.add(new String(arr));

            arr[i] = (char) ((ch - '0' - 1 + 10) % 10 + '0'); // To decrease the number to previous number.
            res.add(new String(arr));

            arr[i] = ch; // Reset the number back to original number.
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(openLock(new String[] { "0201", "0101", "0102", "1212", "2002" }, "0202"));
    }
}
