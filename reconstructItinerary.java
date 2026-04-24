import java.util.*;

public class reconstructItinerary {
    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>(); // Graph: src -> minHeap of destinations

        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).offer(ticket.get(1));
        }

        LinkedList<String> result = new LinkedList<>();

        dfs("JFK", graph, result);
        return result;
    }

    private static void dfs(String src, Map<String, PriorityQueue<String>> graph, LinkedList<String> result) {
        PriorityQueue<String> pq = graph.get(src);

        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll();
            dfs(next, graph, result);
        }

        result.addFirst(src);
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("JFK", "ATL"));
        tickets.add(Arrays.asList("SFO", "ATL"));
        tickets.add(Arrays.asList("ATL", "JFK"));
        tickets.add(Arrays.asList("ATL", "SFO"));

        System.out.println(findItinerary(tickets));
    }
}