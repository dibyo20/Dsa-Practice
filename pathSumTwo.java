import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class pathSumTwo {

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        dfs(root, targetSum, currentPath, result);
        return result;
    }

    private static void dfs(TreeNode node, int targetSum,
            List<Integer> currentPath,
            List<List<Integer>> result) {

        if (node == null)
            return;

        currentPath.add(node.val);// Add current node

        if (node.left == null && node.right == null) { // Check leaf node
            if (targetSum == node.val) {
                result.add(new ArrayList<>(currentPath)); // Add a copy of current path to result, as this path is
                                                          // valid.
            }
        } else {
            dfs(node.left, targetSum - node.val, currentPath, result);
            dfs(node.right, targetSum - node.val, currentPath, result);
        }
        currentPath.remove(currentPath.size() - 1); // Backtrack
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        List<List<Integer>> result = pathSum(root, targetSum);
        System.out.println(result);
    }
}