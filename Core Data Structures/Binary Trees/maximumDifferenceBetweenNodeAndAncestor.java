public class maximumDifferenceBetweenNodeAndAncestor {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }

    public static int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private static int dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return 0;
        }

        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        int current = max - min;

        int left = dfs(root.left, min, max);
        int right = dfs(root.right, min, max);

        return Math.max(current, Math.max(left, right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        System.out.println(maxAncestorDiff(root));
    }
}
