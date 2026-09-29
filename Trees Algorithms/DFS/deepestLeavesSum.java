public class deepestLeavesSum {
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

    public static int maxDepth = -1;
    public static int sum = 0;

    public static int sum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private static void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (depth > maxDepth) {
            maxDepth = depth;
            sum = root.val;
        } else if (depth == maxDepth) {
            sum += root.val;
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        System.out.println(sum(root));
    }
}
