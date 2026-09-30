import java.util.*;

public class deleteNodesAndReturnForest {
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

    public static HashSet<Integer> toDelete = new HashSet<>();
    public static List<TreeNode> res = new ArrayList<>();

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int node : to_delete) {
            toDelete.add(node);
        }
        dfs(root, true);
        return res;
    }

    private static TreeNode dfs(TreeNode root, boolean isRoot) {
        if (root == null) {
            return null;
        }
        boolean isDeleted = toDelete.contains(root.val);
        if (isRoot && !isDeleted) {
            res.add(root);
        }
        root.left = dfs(root.left, isDeleted);
        root.right = dfs(root.right, isDeleted);
        return isDeleted ? null : root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int[] to_delete = {3, 5};
        List<TreeNode> res = delNodes(root, to_delete);
        for (TreeNode node : res) {
            System.out.println(node.val);
        }
    }
}
