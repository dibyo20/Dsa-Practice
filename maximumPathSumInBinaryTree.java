public class maximumPathSumInBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(Node root) {
        maxGain(root);
        return maxSum;
    }

    private static int maxGain(Node root) {
        if (root == null) {
            return 0;
        }

        int leftGain = Math.max(0, maxGain(root.left)); // Ignore negative paths
        int rightGain = Math.max(0, maxGain(root.right)); // Ignore negative paths

        int currentPathSum = root.data + leftGain + rightGain; // Path passing through current node
        maxSum = Math.max(maxSum, currentPathSum);

        return root.data + Math.max(leftGain, rightGain); // Return max single-path gain
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);

        System.out.println("Maximum Path Sum: " + maxPathSum(root));
    }
}
