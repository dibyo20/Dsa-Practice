public class pseudoPalindromicPathsInABinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int count = 0;
    static int[] freq = new int[10];

    public static int pseudoPalindromicPaths(TreeNode root) {
        count = 0;
        freq = new int[10];
        dfs(root);
        return count;
    }

    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        freq[root.val]++;
        if (root.left == null && root.right == null) {
            if (isPseudoPalindromic()) {
                count++;
            }
        }

        dfs(root.left);
        dfs(root.right);
        freq[root.val]--;
    }

    private static boolean isPseudoPalindromic() {
        int oddCount = 0;
        for (int i = 0; i < 10; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);

        System.out.println(pseudoPalindromicPaths(root));
    }

}
