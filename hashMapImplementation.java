import java.util.*;

public class hashMapImplementation {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node>[] buckets;

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N; // Ensure non-negative index and within bounds i.e. 0 to
                                     // buckets.length - 1
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return di; 
                }
                di++;
            }
            return -1;

        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            buckets = new LinkedList[N * 2];
            N *= 2; // Double the size of the buckets
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }
            n = 0; // Reset size

            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> ll = oldBuckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value); // Reinsert the old nodes into the new buckets.
                    // Note: Here it is calling the 'put' method to handle collisions and size increment.
                }
            }
        }

        public void put(K key, V value) { // TC O(1) on average, O(N) in worst case
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                // Key already exists, update value
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                // Key does not exist, adding new key-value pair
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) { // TC O(1) on average, O(N) in worst case
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                return true; // Key exists
            } else {
                return false; // Key does not exist
            }
        }

        public V get(K key) { // TC O(1) on average, O(N) in worst case
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value; // Return the value associated with the key
            } else {
                return null; // Key does not exist
            }
        }

        public V remove(K key) { // TC O(1) on average, O(N) in worst case
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--; // Decrease size of the map
                return node.value; // Return the removed value
            } else {
                return null; // Key does not exist
            }
        }

        public ArrayList<K> keySet() { // TC O(N)
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys; // Return all keys in the map
        }

        public boolean isEmpty() { // TC O(1)
            return n == 0;
        }

    }

    public static void main(String args[]) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 1);
        hm.put("USA", 2);
        hm.put("China", 3);
        hm.put("Japan", 4);

        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println("Key: " + key + ", Value: " + hm.get(key));
        }
    }
}
