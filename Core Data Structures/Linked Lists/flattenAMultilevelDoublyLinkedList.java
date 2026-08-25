import java.util.*;

public class flattenAMultilevelDoublyLinkedList {
    public static class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
            this.child = null;
        }
    }

    public static Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Stack<Node> stack = new Stack<>();
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                if (curr.next != null) {
                    stack.push(curr.next);
                }
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                curr = curr.next;
            } else if (curr.next == null && !stack.isEmpty()) {
                curr.next = stack.pop();
                curr.next.prev = curr;
                curr = curr.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.next.next.child = new Node(7);
        head.next.next.child.next = new Node(8);
        head.next.next.child.next.next = new Node(9);
        head.next.next.child.next.next.next = new Node(10);

        head.next.next.child.next.child = new Node(11);
        head.next.next.child.next.child.next = new Node(12);

        Node ans = flatten(head);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}
