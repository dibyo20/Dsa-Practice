import java.util.*;

public class keysAndRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int key = q.poll();
            for (int room : rooms.get(key)) {
                if (!visited[room]) {
                    visited[room] = true;
                    q.add(room);
                }
            }
        }

        for (boolean room : visited) {
            if (!room) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(new ArrayList<>());

        System.out.println(canVisitAllRooms(rooms));
    }
}
