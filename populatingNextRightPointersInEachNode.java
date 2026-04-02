class Node {
    int val;
    Node left;
    Node right;
    Node next;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}

public class populatingNextRightPointersInEachNode {
    public static Node connect(Node root) {
        if (root == null)
            return null;

        Node leftMost = root;

        while (leftMost.left != null) {
            Node curr = leftMost;

            while (curr != null) {
                curr.left.next = curr.right; // connect left -> right

                if (curr.next != null) { // connect right -> next.left
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    public static void printLevels(Node root) { // Helper function to print using next pointers
        Node levelStart = root;

        while (levelStart != null) {
            Node curr = levelStart;
            while (curr != null) {
                System.out.print(curr.val + " -> ");
                curr = curr.next;
            }
            System.out.println("NULL");
            levelStart = levelStart.left;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        connect(root);
        printLevels(root);
    }
}
