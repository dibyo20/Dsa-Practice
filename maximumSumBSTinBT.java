public class maximumSumBSTinBT {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Info {
        boolean isBST;
        int min;
        int max;
        int sum;

        Info(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    static int maxSum = 0;

    public static int maxSumBST(TreeNode root) {
        postOrder(root);
        return maxSum;
    }

    private static Info postOrder(TreeNode root) {
        if (root == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Info left = postOrder(root.left);
        Info right = postOrder(root.right);

        if (left.isBST && right.isBST &&
                left.max < root.val && root.val < right.min) {

            int currSum = left.sum + right.sum + root.val;

            maxSum = Math.max(maxSum, currSum);

            return new Info(
                    true,
                    Math.min(root.val, left.min),
                    Math.max(root.val, right.max),
                    currSum);
        }

        return new Info(false, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(20);

        System.out.println(maxSumBST(root));
    }
}