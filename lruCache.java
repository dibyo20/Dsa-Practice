import java.util.HashMap;

public class lruCache {

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static int capacity;
    private static HashMap<Integer, Node> map;
    private static Node head, tail; // Dummy head and tail nodes, the actual nodes will be between these two.

    public lruCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Create dummy nodes
        head = new Node(0, 0);   // Dummy head (MRU side)
        tail = new Node(0, 0);   // Dummy tail (LRU side)

        head.next = tail;
        tail.prev = head;
    }

    public static int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        addToFront(node);

        return node.value;
    }

    public static void put(int key, int value) {

        if (map.containsKey(key)) { // If key already exists, update the value and move it to front
            Node node = map.get(key);
            node.value = value;

            remove(node);
            addToFront(node);
        } else { // If key does not exist, insert new key-value pair by removing LRU if capacity
                 // is full

            if (map.size() == capacity) {
                Node lru = tail.prev; // Least Recently Used
                remove(lru);
                map.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToFront(newNode);
        }
    }

    private static void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private static void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {

        lruCache cache = new lruCache(2);

        cache.put(1, 1); // cache = {1=1}
        cache.put(2, 2); // cache = {1=1, 2=2}

        System.out.println(cache.get(1)); // 1

        cache.put(3, 3); // removes key 2
        System.out.println(cache.get(2)); // -1

        cache.put(4, 4); // removes key 1
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}
