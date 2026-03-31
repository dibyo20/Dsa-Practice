import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class pathSumThree {
    public static int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);

        return dfs(root, 0, targetSum, map);
    }

    private static int dfs(TreeNode node, long currSum, int target, HashMap<Long, Integer> map) {
        if (node == null)
            return 0;

        currSum += node.val;

        int count = map.getOrDefault(currSum - target, 0);

        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        count += dfs(node.left, currSum, target, map);
        count += dfs(node.right, currSum, target, map);

        map.put(currSum, map.get(currSum) - 1);

        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        root.right.right = new TreeNode(11);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.left.right.right = new TreeNode(1);

        int targetSum = 8;
        int result = pathSum(root, targetSum);
        System.out.println("Number of paths: " + result);
    }
}
