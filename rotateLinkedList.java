public class rotateLinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) { // TC: O(1)
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public Node rotateList(Node head, int k) { // TC: O(n*k)
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        Node prev;
        for (int i = 0; i < k; i++) { // Rotate k times
            prev = head;
            while (prev.next.next != null) { // Traverse to the second last node
                prev = prev.next;
            }
            Node last = prev.next; // Get the last node
            prev.next = null; // Detach the last node
            last.next = head; // Point last node to the current head
            head = last; // Update head to the last node
        }
        return head;
    }

    public static Node rotateListOptimized(Node head, int k) { // TC: O(n)
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        Node temp = head;
        int length = 1;
        while (temp.next != null) { //To find length of linked list and also reach to last node
            temp = temp.next;
            length++;
        }

        temp.next = head; // Connect last node to head to make it circular
        k = k % length; // In case k is greater than length of list, then take modulo so that we do minimum
                        // rotations and avoid extra rotations because rotating by length of list results in same list.

        int stepsToNewHead = length - k;
        Node newTail = head; // It is a pointer to reach new tail node.

        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next; // Move newTail to the (length - k)th node.
        }
        Node newHead = newTail.next; // New head is next of new tail
        newTail.next = null; // Break the circular link, So new tail points to null and avoid cycle in linked list.
        return newHead;
    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        rotateLinkedList list = new rotateLinkedList();
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        int k = 10;
        list.printList(head);
        // head = list.rotateList(head, k);
        // System.out.println("After rotating by " + k + " positions:");
        // list.printList(head);

        head = rotateListOptimized(head, k);
        System.out.println("After rotating by " + k + " positions (Optimized):");
        list.printList(head);
        
    }
}
