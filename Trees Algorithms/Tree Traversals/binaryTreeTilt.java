public class binaryTreeTilt {
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

    public static int tilt = 0;

    public static int findTilt(TreeNode root) {
        dfs(root);
        return tilt;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        tilt += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(findTilt(root));
    }
}
