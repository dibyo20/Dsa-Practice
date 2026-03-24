public class mergeKSortedLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Merge two sorted linked lists
    public static Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node(-1);
        Node tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }

    public static Node mergeKLists(Node[] lists) {
        if (lists.length == 0)
            return null;

        Node result = lists[0];

        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }

        return result;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {

        Node l1 = new Node(1);
        l1.next = new Node(3);

        Node l2 = new Node(6);
        l2.next = new Node(8);

        Node l3 = new Node(9);
        l3.next = new Node(10);

        Node[] lists = { l1, l2, l3 };

        Node result = mergeKLists(lists);
        printList(result);
    }
}
