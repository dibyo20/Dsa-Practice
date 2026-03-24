public class deleteXNodeInBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node deleteXNode(Node root, int x) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null && root.data == x) {
            return null;
        }

        root.left = deleteXNode(root.left, x);
        root.right = deleteXNode(root.right, x);

        return root;
    }

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(3);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        // root.right.left = new Node(1);
        // root.right.right = new Node(1);

        root = deleteXNode(root, 3);
        inorder(root);

    }
}
