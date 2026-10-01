import java.util.*;

public class allPossibleFullBinaryTrees {
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

    public static Map<Integer, List<TreeNode>> dp = new HashMap<>();

    public static List<TreeNode> allPossibleFBT(int n) {
        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        List<TreeNode> ans = new ArrayList<>();
        if (n % 2 == 0) {
            return ans;
        }

        if (n == 1) {
            ans.add(new TreeNode(0));
            dp.put(n, ans);
            return ans;
        }

        for (int leftNodes = 1; leftNodes < n; leftNodes += 2) {
            int rightNodes = n - 1 - leftNodes;

            List<TreeNode> leftTrees = allPossibleFBT(leftNodes);
            List<TreeNode> rightTrees = allPossibleFBT(rightNodes);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        dp.put(n, ans);
        return ans;
    }

    public static void main(String[] args) {
        List<TreeNode> ans = allPossibleFBT(7);
        for (TreeNode node : ans) {
            System.out.println(node.val);
        }
    }
}
