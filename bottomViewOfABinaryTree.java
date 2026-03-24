import java.util.*;

public class bottomViewOfABinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static List<Integer> bottomView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Map<Integer, Integer> map = new TreeMap<>(); // To store horizontal distance and corresponding node's value in
                                                     // ascending order of horizontal distance.

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0)); // Here offer() is used instead of add(), as add() throws exception if it fails
                                        // to insert.

        while (!queue.isEmpty()) { // It is doing BFS traversal.

            Pair current = queue.poll(); // Here poll() is used instead of remove(), as remove() throws exception if the
                                         // queue is empty.
            TreeNode node = current.node;
            int hd = current.hd;

            map.put(hd, node.val);

            if (node.left != null) { // If left child exists
                queue.offer(new Pair(node.left, hd - 1));
            }

            if (node.right != null) { // If right child exists
                queue.offer(new Pair(node.right, hd + 1));
            }
        }

        for (int val : map.values()) {
            result.add(val);
        }

        return result;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        List<Integer> result = bottomView(root);
        System.out.println(result);
    }
}
