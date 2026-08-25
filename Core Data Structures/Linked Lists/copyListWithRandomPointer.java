public class copyListWithRandomPointer {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node curr = head;

        while (curr != null) {
            Node temp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = temp;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node newHead = head.next;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = temp.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            curr = curr.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        Node copiedListHead = copyRandomList(head);

        Node curr = copiedListHead;
        while (curr != null) {
            System.out.print("Node value: " + curr.val + ", Random value: ");
            if (curr.random != null) {
                System.out.println(curr.random.val);
            } else {
                System.out.println("null");
            }
            curr = curr.next;
        }
    }
}