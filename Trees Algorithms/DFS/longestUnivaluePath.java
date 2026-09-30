public class longestUnivaluePath {
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

    public static int max = 0;

    public static int longestPath(TreeNode root) {
        dfs(root);
        return max;
    }

    private static int dfs(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        int leftPath = 0;
        int rightPath = 0;

        if(root.left != null && root.left.val == root.val){
            leftPath = left + 1;
        }

        if(root.right != null && root.right.val == root.val){
            rightPath = right + 1;
        }

        max = Math.max(max, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(longestPath(root));
    }
}
