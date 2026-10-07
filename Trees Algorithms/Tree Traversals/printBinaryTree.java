import java.util.*;

public class printBinaryTree {
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

    public static int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static List<List<String>> printTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        int h = height(root);
        int row = h + 1;
        int col = (int) Math.pow(2, h + 1) - 1;

        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<String> r = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                r.add("");
            }
            res.add(r);
        }
        dfs(root, 0, (col - 1) / 2, res, h);
        return res;
    }

    public static void dfs(TreeNode root, int row, int col, List<List<String>> res, int h) {
        if (root == null) {
            return;
        }

        res.get(row).set(col, String.valueOf(root.val));
        
        int offset = (int) Math.pow(2, h - row - 1);

        if( root.left != null) {
            dfs(root.left, row + 1, col - offset, res, h);
        }

        if (root.right != null) {
            dfs(root.right, row + 1, col + offset, res, h);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        List<List<String>> res = printTree(root);
        System.out.println(res);
    }
}
