import java.util.*;

public class findModeInBinarySearchTree {
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

    public static List<Integer> result = new ArrayList<>();
    public static int count = 0;
    public static int maxCount = 0;
    public static int prev = 0;
    public static boolean hasPrev = false;

    public static int[] findMode(TreeNode root) {
        inorder(root);
        int[] ans = new int[result.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    public static void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);

        if (hasPrev && root.val == prev) {
            count++;
        } else {
            count = 1;
        }

        if (count == maxCount) {
            result.add(root.val);
        } else if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(root.val);
        }

        prev = root.val;
        hasPrev = true;

        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        int[] ans = findMode(root);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
