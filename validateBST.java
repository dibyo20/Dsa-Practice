public class validateBST {
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

    public static Node insert(Node root, int val) { // TC: O(H), where 'H' is height of tree
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean isValidBST(Node root, Node min, Node max) { // TC: O(N), where 'N' is number of nodes in tree and SC: O(H), where 'H' is height of tree.
        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {
            return false;
        }

        else if (max != null && root.data >= max.data) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static boolean isValidBST(TreeNode root) {  // This is another approach to validate BST using inorder traversal. And have same time complexity as above approach.
        return inorder(root);
    }

    static long prev = Long.MIN_VALUE;

    public static boolean inorder(TreeNode node) {
        if (node == null)
            return true;

        if (!inorder(node.left))
            return false;

        if (node.val <= prev)
            return false;
        prev = node.val;

        return inorder(node.right);
    }

    public static void main(String args[]) {
        int values[] = { 8, 5, 3, 6, 10, 11, 14 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        if (isValidBST(root, null, null)) {
            System.out.println("valid");
        } else {
            System.out.println("Not valid");
        }

    }
}
