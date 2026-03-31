import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class binaryTreePaths {
    public static List<String> binaryTreeAllPaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;

        dfs(root, new StringBuilder(), result);
        return result;
    }

    private static void dfs(TreeNode node, StringBuilder path, List<String> result) {
        if (node == null)
            return;

        int lengthBefore = path.length();

        if (path.length() != 0) {
            path.append("->");
        }
        path.append(node.val);

        if (node.left == null && node.right == null) {
            result.add(path.toString());
        } else {
            dfs(node.left, path, result);
            dfs(node.right, path, result);
        }

        path.setLength(lengthBefore);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> result = binaryTreeAllPaths(root);
        for (String path : result) {
            System.out.println(path);
        }
    }
}
