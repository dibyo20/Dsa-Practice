public class distributeCoinsInBinaryTree {
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

    public static int moves = 0;

    public static int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private static int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int leftBalance = dfs(root.left);
        int rightBalance = dfs(root.right);

        moves += Math.abs(leftBalance);
        moves += Math.abs(rightBalance);

        return root.val + leftBalance + rightBalance - 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        System.out.println(distributeCoins(root));
    }
}
