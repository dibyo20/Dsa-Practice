public class bstIntoGreaterSumBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int sum = 0;

    public static TreeNode bstToGst(TreeNode root) {
        reverseInorder(root);
        return root;
    }

    private static void reverseInorder(TreeNode root) {
        if (root == null)
            return;

        reverseInorder(root.right);

        int originalValue = root.val;
        root.val = sum;
        sum += originalValue;

        reverseInorder(root.left);
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null)
            return;

        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(5);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(20);

        inorderTraversal(bstToGst(root));
    }

}
