import java.util.ArrayList;
import java.util.List;

public class allNodesDistanceKInBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static List<Integer> ans = new ArrayList<>();

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root, target, k);
        return ans;
    }

    private static int dfs(TreeNode root, TreeNode target, int k) {
        if (root == null)
            return -1;

        if (root == target) {
            collectDown(root, k);
            return 0;
        }

        int left = dfs(root.left, target, k); // This helps to find the distance of the target node from the left subtree.
        if (left != -1) {
            int dist = left + 1;

            if (dist == k) {
                ans.add(root.val);
            } else {
                collectDown(root.right, k - dist - 1);
            }
            return dist;
        }

        int right = dfs(root.right, target, k); // This helps to find the distance of the target node from the right subtree.
        if (right != -1) {
            int dist = right + 1;

            if (dist == k) {
                ans.add(root.val);
            } else {
                collectDown(root.left, k - dist - 1);
            }
            return dist;
        }

        return -1;
    }

    private static void collectDown(TreeNode root, int dist) { // This function collects nodes that are just below the target node at a distance of k. We will call this function when we find the target node in our DFS traversal. It will collect all nodes that are at a distance of k from the target node in the downward direction.
        if (root == null || dist < 0) { 
            return;
        }

        if (dist == 0) {
            ans.add(root.val);
            return;
        }

        collectDown(root.left, dist - 1);
        collectDown(root.right, dist - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println(distanceK(root, root.left, 2));
    }
}
