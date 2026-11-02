public class maximumProductOfSplittedBinaryTree {
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

    public static long totalSum = 0;
    public static long maxProduct = 0;
    public static long MOD = 1000000007;

    public static int maxProduct(TreeNode root) {
        totalSum = getSum(root);
        getMaxProduct(root);
        return (int) (maxProduct % MOD);
    }

    public static long getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long leftSum = getSum(root.left);
        long rightSum = getSum(root.right);
        return root.val + leftSum + rightSum;
    }

    public static long getMaxProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long leftSum = getMaxProduct(root.left);
        long rightSum = getMaxProduct(root.right);
        long currentSum = root.val + leftSum + rightSum;
        maxProduct = Math.max(maxProduct, currentSum * (totalSum - currentSum));
        return currentSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(maxProduct(root));
    }
}
