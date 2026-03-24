public class intersectionInLinkedList {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;
    public int size;

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

    public void printList(Node head) { // TC: O(n)
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public Node intersectionNode(Node head1, Node head2) {
        int size1 = 0, size2 = 0;
        Node current1 = head1;
        Node current2 = head2;

        while (current1 != null) { // Calculate size of first list
            size1++;
            current1 = current1.next;
        }

        while (current2 != null) { // Calculate size of second list
            size2++;
            current2 = current2.next;
        }

        int diff = Math.abs(size1 - size2);
        current1 = head1;
        current2 = head2;
        if (size1 > size2) { // Increase the pointer of the longer list by the difference in sizes to make the lengths equal of both lists.
            for (int i = 0; i < diff; i++) {
                current1 = current1.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                current2 = current2.next;
            }
        }
        while (current1 != null && current2 != null) { // Traverse both lists together until intersection is found
            if (current1 == current2) {
                return current1; // Intersection node found
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return null; // If no intersection found
    }

    public static void main(String[] args) {
        intersectionInLinkedList list1 = new intersectionInLinkedList();
        intersectionInLinkedList list2 = new intersectionInLinkedList();

        // Creating first linked list: 1 -> 2 -> 3 -> 4 -> 5
        list1.addFirst(5);
        list1.addFirst(4);
        list1.addFirst(3);
        list1.addFirst(2);
        list1.addFirst(1);

        // Creating second linked list: 9 -> 8
        list2.addFirst(8);
        list2.addFirst(9);

        // Creating intersection at node with value 3
        Node intersectionNode = list1.head.next.next; // Node with value 3
        list2.tail.next = intersectionNode; // Linking tail of list2 to intersectionNode

        // Printing both lists
        System.out.println("List 1:"); // Output: 1 -> 2 -> 3 -> 4 -> 5 -> null
        list1.printList(list1.head);
        System.out.println("List 2:"); // Output: 9 -> 8 -> 3 -> 4 -> 5 -> null
        list2.printList(list2.head);
        // Finding intersection
        Node intersection = list1.intersectionNode(list1.head, list2.head);
        System.out.println("Intersection at node : " + intersection.data);
    }
}
