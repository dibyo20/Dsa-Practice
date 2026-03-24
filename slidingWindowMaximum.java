import java.util.PriorityQueue;

public class slidingWindowMaximum {
    static class Pair implements Comparable<Pair> {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair p2) {
            return p2.value - this.value; // Max heap based on value, i.e. descending order
        }
    }

    public static void main(String args[]) {   // TC: O(n log k), SC: O(k)
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int res[] = new int[arr.length - k + 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // 1st window
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().value;

        for (int i = k; i < arr.length; i++) {
            while (!pq.isEmpty() && pq.peek().index <= i - k) {
                pq.remove();
            }

            pq.add(new Pair(arr[i], i)); // Add the next element
            res[i - k + 1] = pq.peek().value;
        }

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
