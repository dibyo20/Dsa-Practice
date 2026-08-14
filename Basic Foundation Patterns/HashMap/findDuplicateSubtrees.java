import java.util.*;

public class findDuplicateSubtrees {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static Map<String, Integer> map = new HashMap<>();
    static List<TreeNode> ans = new ArrayList<>();

    public static List<TreeNode> findDupSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }

    private static String dfs(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = dfs(root.left);
        String right = dfs(root.right);

        String subtree = root.val + "," + left + "," + right;
        int count = map.getOrDefault(subtree, 0);

        if (count == 1) {
            ans.add(root);
        }

        map.put(subtree, count + 1);
        return subtree;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);

        List<TreeNode> dupSubtrees = findDupSubtrees(root);
        for (TreeNode node : dupSubtrees) {
            System.out.println(node.val);
        }
    }

}
