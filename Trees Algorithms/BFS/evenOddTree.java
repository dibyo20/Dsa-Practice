import java.util.*;

public class evenOddTree {
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

    public static boolean isEvenOddTree(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int prev = level % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (level % 2 == 0) {
                    if (curr.val % 2 == 0 || curr.val <= prev)
                        return false;
                } else {
                    if (curr.val % 2 != 0 || curr.val >= prev)
                        return false;
                }
                prev = curr.val;
                if (curr.left != null)
                    queue.add(curr.left);

                if (curr.right != null)
                    queue.add(curr.right);
            }
            level++;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(12);
        root.left.left.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.right.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(2);
        System.out.println(isEvenOddTree(root));
    }
}
