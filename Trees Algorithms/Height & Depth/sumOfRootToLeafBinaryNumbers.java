public class sumOfRootToLeafBinaryNumbers {
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

    public static int sumOfRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public static int dfs(TreeNode root, int curr) {
        if (root == null) {
            return 0;
        }

        curr = curr * 2 + root.val;

        if (root.left == null && root.right == null) {
            return curr;
        }
        return dfs(root.left, curr) + dfs(root.right, curr);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(sumOfRootToLeaf(root));
    }
}
