public class closestMinDiffElementInBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int closestValueIterative(TreeNode root, int K) { // TC: O(H) SC: O(1)
        int closest = root.val;

        while (root != null) {

            if (Math.abs(root.val - K) < Math.abs(closest - K)) { // Update closest if current node is better
                closest = root.val;
            }

            if (K < root.val) {
                root = root.left;
            } else if (K > root.val) {
                root = root.right;
            } else { // Exact match found
                break;
            }
        }

        return closest;
    }

    public static int closestValueRecursive(TreeNode root, int K) { // TC: O(H) SC: O(H), as it uses recursion stack.
        return helper(root, K, root.val);
    }

    private static int helper(TreeNode root, int K, int closest) {
        if (root == null)
            return closest;

        if (Math.abs(root.val - K) < Math.abs(closest - K)) {
            closest = root.val;
        }

        if (K < root.val)
            return helper(root.left, K, closest);
        else if (K > root.val)
            return helper(root.right, K, closest);
        else
            return root.val; // exact match
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(5);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(20);

        System.out.println(closestValueIterative(root, 10));
        System.out.println(closestValueRecursive(root, 10));
    }
}