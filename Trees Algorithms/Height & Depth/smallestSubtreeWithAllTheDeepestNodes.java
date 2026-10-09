public class smallestSubtreeWithAllTheDeepestNodes {
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

    public static class Result {
        TreeNode node;
        int height;

        Result(TreeNode node, int height) {
            this.node = node;
            this.height = height;
        }
    }

    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    public static Result dfs(TreeNode root) {
        if (root == null) {
            return new Result(null, 0);
        }

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        if (left.height == right.height) {
            return new Result(root, left.height + 1);
        } else if (left.height > right.height) {
            return new Result(left.node, left.height + 1);
        }

        return new Result(right.node, right.height + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println(subtreeWithAllDeepest(root).val);
    }
}
