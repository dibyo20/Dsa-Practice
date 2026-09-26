public class findBottomLeftTreeValue {
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

    public static int ans;
    public static int maxLevel = -1;

    public static int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private static void dfs(TreeNode root, int level) {
        if (root == null)
            return;

        if (level > maxLevel) {
            maxLevel = level;
            ans = root.val;
        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);

        System.out.println(findBottomLeftValue(root));
    }
}
