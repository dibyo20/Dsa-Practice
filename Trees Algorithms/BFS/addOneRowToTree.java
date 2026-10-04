import java.util.*;

public class addOneRowToTree {
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

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (level == depth - 1) {
                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();
                    TreeNode oldLeft = curr.left;
                    TreeNode oldRight = curr.right;

                    curr.left = new TreeNode(val);
                    curr.right = new TreeNode(val);

                    curr.left.left = oldLeft;
                    curr.right.right = oldRight;
                }
                break;
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();

                    if (curr.left != null) {
                        queue.add(curr.left);
                    }
                    if (curr.right != null) {
                        queue.add(curr.right);
                    }
                }
                level++;
            }
        }
        return root;
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);

        preOrder(root);
        System.out.println();
        TreeNode ans = addOneRow(root, 1, 2);
        preOrder(ans);
    }
}
