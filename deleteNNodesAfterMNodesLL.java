import java.util.*;

public class deleteNNodesAfterMNodesLL {
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

    public static void deleteNodes(Node head, int M, int N) {
        if (head == null) {
            return;
        }
        Node prev = head;
        for (int i = 0; i < M - 1 && prev != null; i++) { // Move M nodes ahead
            prev = prev.next;
        }
        // After moving M nodes, prev is at Mth node, now after this we need to delete N nodes

        Node curr = prev; // Start from Mth node
        for (int j = 0; j <= N && curr != null; j++) { // Move N nodes ahead
            curr = curr.next;
        }
        if (prev != null) {
            prev.next = curr; // Link Mth node to the (M+N+1)th node
        }
        deleteNodes(curr, M, N); // Recur for the remaining list
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        deleteNNodesAfterMNodesLL list = new deleteNNodesAfterMNodesLL();
        list.addFirst(10);
        list.addFirst(9);
        list.addFirst(8);
        list.addFirst(7);
        list.addFirst(6);
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        System.out.println("Original List:");
        printList(head);

        int M = 2; // Number of nodes to keep
        int N = 1; // Number of nodes to delete
        deleteNodes(head, M, N);
        System.out.println("List after deleting Nodes:");
        printList(head);
    }
}
