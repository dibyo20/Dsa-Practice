import java.util.PriorityQueue;

public class connectNRopes {
    public static void main(String args[]) {
        int ropes[] = { 2, 3, 3, 4, 6 };

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;
        while (pq.size() > 1) {
            int min = pq.remove();
            int min2 = pq.remove();
            cost += min + min2; // Adding the cost of connecting the two smallest ropes
            pq.add(min + min2); // Adding the new rope back to the priority queue
        }

        System.out.println("Minimum cost to connect all ropes: " + cost);
    }
}
