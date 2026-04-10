import java.util.*;

public class keysAndRooms {

    public static boolean canVisitAllRoomsDFS(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0, rooms, visited);

        for (boolean v : visited) {
            if (!v)
                return false;
        }
        return true;
    }

    private static void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        visited[room] = true;
        for (int key : rooms.get(room)) {
            if (!visited[key]) {
                dfs(key, rooms, visited);
            }
        }
    }

    public static boolean canVisitAllRoomsBFS(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int room = queue.poll();

            for (int key : rooms.get(room)) {
                if (!visited[key]) {
                    visited[key] = true;
                    queue.add(key);
                }
            }
        }

        for (boolean v : visited) {
            if (!v)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(Arrays.asList());

        System.out.println(canVisitAllRoomsDFS(rooms));
        System.out.println(canVisitAllRoomsBFS(rooms));
    }
}