import java.util.*;

public class busRoutes {
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                if (!map.containsKey(stop)) {
                    map.put(stop, new ArrayList<>());
                }
                map.get(stop).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visitedBus = new boolean[routes.length];
        q.add(source);
        int buses = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            buses++;
            while (size-- > 0) {
                int curr = q.poll();
                if (!map.containsKey(curr)) {
                    continue;
                }
                for (int bus : map.get(curr)) {
                    if (!visitedBus[bus]) {
                        visitedBus[bus] = true;
                        for (int stop : routes[bus]) {
                            if (stop == target)
                                return buses;
                            q.add(stop);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] routes = { { 1, 2, 7 }, { 3, 6, 7 } };
        int source = 1;
        int target = 6;
        System.out.println(numBusesToDestination(routes, source, target));
    }
}
