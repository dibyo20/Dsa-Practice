public class maximumSumBSTInBinaryTree {
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

    public static class Info {
        boolean isBSt;
        int max;
        int min;
        int sum;

        public Info(boolean isBST, int max, int min, int sum) {
            this.isBSt = isBST;
            this.max = max;
            this.min = min;
            this.sum = sum;
        }
    }

    public static int maxSum = 0;

    public static int maxSumBST(TreeNode root) {
        maxSumBSTUtil(root);
        return maxSum;
    }

    public static Info maxSumBSTUtil(TreeNode root) {
        if (root == null) {
            return new Info(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        Info left = maxSumBSTUtil(root.left);
        Info right = maxSumBSTUtil(root.right);

        if (left.isBSt && right.isBSt && root.val > left.max && root.val < right.min) {
            int sum = left.sum + right.sum + root.val;
            maxSum = Math.max(maxSum, sum);
            return new Info(true, Math.max(root.val, Math.max(left.max, right.max)),
                    Math.min(root.val, Math.min(left.min, right.min)), sum);
        }

        return new Info(false, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(6);

        System.out.println(maxSumBST(root));
    }
}
