public class increasingOrderSearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode curr;

    public static TreeNode increasingBST(TreeNode root) {
        if (root == null)
            return null;

        TreeNode dummy = new TreeNode(0);
        curr = dummy;
        inorder(root);

        return dummy.right;
    }

    public static void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);

        curr.right = root;
        root.left = null;
        curr = root;

        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(8);
        root.left.left.left = new TreeNode(1);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        TreeNode ans = increasingBST(root);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.right;
        }
    }
}
