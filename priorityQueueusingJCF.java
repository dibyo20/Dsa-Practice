import java.util.*;

public class priorityQueueusingJCF {
    static class student implements Comparable<student> {
        int rank;
        String name;

        student(int rank, String name) {
            this.rank = rank;
            this.name = name;
        }

        @Override
        public int compareTo(student s2) {
            // This will sort the students in ascending order of their rank
            return this.rank - s2.rank; // TC: O(1)
        }
    }

    public static void main(String args[]) {
        // PriorityQueue<student> pq = new PriorityQueue<>();  // For ascending order
        PriorityQueue<student> pq = new PriorityQueue<>(Comparator.reverseOrder());  // For descending order

        pq.add(new student(4, "A")); // TC: O(log n)
        pq.add(new student(2, "B")); // TC: O(log n)
        pq.add(new student(1, "C")); // TC: O(log n)
        pq.add(new student(3, "D")); // TC: O(log n) 

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name +" -> "+ pq.peek().rank); // TC: O(1)
            pq.remove(); // TC: O(log n)

        }
    }
}
