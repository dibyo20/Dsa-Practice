public class reverseLinkedListAtMiddle {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;

    public void addFirst(int data) { // TC: O(1)
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void printList() { // TC: O(n)
        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public Node reverseMiddle(Node head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        Node dummy = new Node(-1);
        dummy.next = head;
        Node prev = dummy;

        for (int i = 0; i < left; i++) {
            prev = prev.next;
        }

        Node curr = prev.next;
        Node next;

        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummy.next;
    }

    public static void main(String args[]) {
        reverseLinkedListAtMiddle ll = new reverseLinkedListAtMiddle();
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.printList();
        ll.head = ll.reverseMiddle(ll.head, 1, 3);
        ll.printList();
    }
}
