import java.util.*;

public class heaps {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data); // TC: O(1)

            int x = arr.size() - 1; // Index of child element
            int p = (x - 1) / 2; // Parent index

            while (arr.get(x) < arr.get(p)) { // TC: O(log n)
                // Swap child and parent
                int temp = arr.get(x);
                arr.set(x, arr.get(p));
                arr.set(p, temp);

                x = p;
                p = (x - 1) / 2;
            }
        }

        public int peek() {
            if (arr.size() == 0) {
                return -1; // Heap is empty
            }
            return arr.get(0); // Return the root element
        }

        private void heapify(int i) { // TC: O(log n)
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(left) < arr.get(minIdx)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(right) < arr.get(minIdx)) {
                minIdx = right;
            }

            if (minIdx != i) {
                // Swap the current element with the smallest child
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                heapify(minIdx); // Recursively heapify the affected subtree
            }
        }

        public int remove() {
            int data = arr.get(0);

            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            arr.remove(arr.size() - 1);

            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while(!h.isEmpty()) {
            System.out.println(h.peek()); 
            h.remove(); 
        }
    }
}
