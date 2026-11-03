public class minimumDistanceBetweenBSTNodes {
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

    public static TreeNode prev = null;
    public static int minDiff = Integer.MAX_VALUE;

    public static int minDiffInBST(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    public static void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, root.val - prev.val);
        }
        prev = root;

        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(minDiffInBST(root));
    }
}
