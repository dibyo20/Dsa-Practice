public class longestZigZagPathInABinaryTree {
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

    public static class Pair {
        int left;
        int right;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static int ans;

    public static int longestZigZag(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private static Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair(-1, -1);
        }

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        int leftLen = 1 + left.right;
        int rightLen = 1 + right.left;

        ans = Math.max(ans, Math.max(leftLen, rightLen));
        return new Pair(leftLen, rightLen);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);

        System.out.println(longestZigZag(root));
    }
}
