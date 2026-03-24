public class oddEvenLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node rearrangeEvenOdd(Node head) {
        if (head == null)
            return null;

        Node evenHead = null, evenTail = null;
        Node oddHead = null, oddTail = null;

        Node curr = head;

        while (curr != null) {
            if (curr.data % 2 == 0) { // EVEN
                if (evenHead == null) {
                    evenHead = evenTail = curr;
                } else {
                    evenTail.next = curr;
                    evenTail = curr;
                }
            } else { // ODD
                if (oddHead == null) {
                    oddHead = oddTail = curr;
                } else {
                    oddTail.next = curr;
                    oddTail = curr;
                }
            }
            curr = curr.next;
        }

        // Connect even list to odd list
        if (evenTail != null) {
            evenTail.next = oddHead;
        }

        if (oddTail != null) {
            oddTail.next = null;
        }

        return (evenHead != null) ? evenHead : oddHead;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Node head1 = new Node(8);
        head1.next = new Node(12);
        head1.next.next = new Node(10);
        head1.next.next.next = new Node(5);
        head1.next.next.next.next = new Node(4);
        head1.next.next.next.next.next = new Node(1);
        head1.next.next.next.next.next.next = new Node(6);

        head1 = rearrangeEvenOdd(head1);
        printList(head1); // Output: 8 -> 12 -> 10 -> 4 -> 6 -> 5 -> 1 -> NULL

        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(5);
        head2.next.next.next = new Node(7);

        head2 = rearrangeEvenOdd(head2);
        printList(head2); // Output: 1 -> 3 -> 5 -> 7 -> NULL

    }
}
