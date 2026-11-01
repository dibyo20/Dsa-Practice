public class sumOfNodesWithEvenValuedGrandparent {
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

    public static int sum = 0;

    public static int sum(TreeNode root) {
        dfs(root, null, null);
        return sum;
    }

    public static void dfs(TreeNode root, TreeNode parent, TreeNode grandParent) {
        if (root == null) {
            return;
        }

        if (grandParent != null && grandParent.val % 2 == 0) {
            sum += root.val;
        }

        dfs(root.left, root, parent);
        dfs(root.right, root, parent);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(9);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);

        System.out.println(sum(root));
    }
}
